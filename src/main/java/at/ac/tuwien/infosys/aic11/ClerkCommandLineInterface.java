package at.ac.tuwien.infosys.aic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.CustomerRating;
import at.ac.tuwien.infosys.aic11.data.Duration;
import at.ac.tuwien.infosys.aic11.data.Money;
import at.ac.tuwien.infosys.aic11.data.Rating;
import at.ac.tuwien.infosys.aic11.data.Warrantor;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestMarshaller;
import at.ac.tuwien.infosys.aic11.services.ContractManagementService;
import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementService;
import at.ac.tuwien.infosys.aic11.services.ShippingService;
import at.ac.tuwien.infosys.aic11.services.security.SecurityInInterceptor;
import at.ac.tuwien.infosys.aic11.services.security.SecurityOutInterceptor;

public class ClerkCommandLineInterface {
	private CustomerRelationsManagementService cr;
	private Customer c;
//	private CustomerMock cmock;
	private CreditRequest creditrequest;
	private ContractManagementService cm;
	private ShippingService sservice;
	
	public ClerkCommandLineInterface(){
		
		this.c = null;
//	    this.cmock = CustomerMock.getInstance();		
		this.creditrequest = null;
		
	    //QName service_name = new QName("http://services.aic11.infosys.tuwien.ac.at/", "CustomerRelationsManagementService");
	    //QName port_name = new QName("http://services.aic11.infosys.tuwien.ac.at/", "CustomerRelationsManagementServicePort");

		String address = "http://localhost:9000/CustomerRelationsManagementService";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(CustomerRelationsManagementService.class);
		factory.setAddress(address);
		
	    this.cr = (CustomerRelationsManagementService)factory.create();
	    
		String cmaddress = "http://localhost:9002/CMService";
		JaxWsProxyFactoryBean cmfactory = new JaxWsProxyFactoryBean();
		
		cmfactory.getInInterceptors().add(new SecurityInInterceptor());
		cmfactory.getOutInterceptors().add(new SecurityOutInterceptor());
		cmfactory.setServiceClass(ContractManagementService.class);
		cmfactory.setAddress(cmaddress);
		
	    this.cm = (ContractManagementService)cmfactory.create();	 
	    
		String saddress = "http://localhost:9003/ShippingService";
		JaxWsProxyFactoryBean sfactory = new JaxWsProxyFactoryBean();
		
		sfactory.getInInterceptors().add(new LoggingInInterceptor());
		sfactory.getOutInterceptors().add(new LoggingOutInterceptor());
		sfactory.setServiceClass(ShippingService.class);
		sfactory.setAddress(saddress);
		
	    this.sservice = (ShippingService)sfactory.create();
		
	}
	
	public void runCommandLineInterface()
	{
		String lastCommand = "";
		String functionCallResult = "";
		
		while(!lastCommand.equals("Q"))
		{
			lastCommand = menuCall(generateInputMenu());
			
			functionCallResult = callFunction(Integer.parseInt(lastCommand));
			
			System.out.println(functionCallResult);
			
			System.out.flush();
		}
		
	}
	
    private String generateInputMenu()
    {
    	String menuString = new String();
      	
    	menuString += "Please select one of the following options: \n\r";
    	menuString += "===========================================\n\r\n\r";
    	menuString += "(1) create customer\n\r"; // create new customer or select from existing mock up
    	menuString += "(2) create credit request\n\r"; // create request and fill with data
    	menuString += "(3) update request\n\r"; // change data here
    	menuString += "(4) generate Offer\n\r";
    	menuString += "(5) accept\n\r"; // disbursement + shipping in thread each
    	menuString += "(6) decline\n\r"; // remove only
    	menuString += "(Q) Exit\n\r";
    	
    	return menuString;
    }
    private String menuCall(String menuString)
    {
    	System.out.print(menuString);
    	return inputLineFromCli("Selection: ");
    }
    
    private String callFunction(int functionId)
    {
    	String returnString = "";
    	
    	switch(functionId)
    	{
    		case 1:
    				generateCreateCustomerInteraction();
					cr.addCustomer(this.c);
    				returnString = "Customer selected.\n\r";
    			break;
    		
    		case 2:
    				if(this.c != null)
    				{
    					// CREATE REQUEST 
    					this.creditrequest = generateCreditRequest();
    					this.creditrequest.setCustomer(this.c);
    					this.c.addCreditrequest(this.creditrequest);
    					
        				returnString = "Credit request created.\n\r";
    				}
    				else
    				{
    					returnString = "Please create or select a customer first.\n\r";
    				}
    			break;
    		case 3:
					if(this.c != null)
					{
						// TODO write function for update REQUEST
						this.creditrequest = generateCreditRequest();
						this.cm.updateCreditRequest(this.creditrequest);
						returnString = "Credit request updated.\n\r";
					}
					else
					{
						returnString = "Please create or select a customer first.\n\r";
					}
    			break;
    		case 4:
    				if(this.creditrequest != null)
    				{
    					this.creditrequest = this.cm.generateCreditRequestOffer(this.creditrequest);   
        				returnString = "Offer created.\n\r";
    				}
    				else
    				{
    					returnString = "Please create credit request first.\n\r";
    				}
    			
    			break;
    		case 5:
    				// accept offer 
					if(this.creditrequest != null && this.creditrequest.getOffer() != null)
					{
						this.sservice.acceptOffer(CreditRequestMarshaller.marshall(creditrequest));
						returnString = "Accapted offer - shipping contract and sending disbursement.\n\r";
					}
					else
					{
						returnString = "Please create credit request and offer first.\n\r";
					}
    			break;
    		case 6:
					if(this.creditrequest != null && this.creditrequest.getOffer() != null)
					{
						// call remove
						this.cm.declineOffer(CreditRequestMarshaller.marshall(this.creditrequest));
						returnString = "Declined offer - deleted offer from the system. \n\r";
					}
					else
					{
						returnString = "Please create credit request and offer first.\n\r";
					}
    			break;
    		default:
    			returnString = "Unknown selection!\n\r";
    	}
    	return returnString;
    }
    
    private void generateCreateCustomerInteraction()
    {
    	// select customer or select to create new
		// create new customer
		this.c = new Customer();
		
		// input new customer
		this.c.setCustomerid(Long.parseLong(inputLineFromCli("CustomerID: ")));
		this.c.setFirstname(inputLineFromCli("First name: "));
		this.c.setLastname(inputLineFromCli("Last name: "));
		
		at.ac.tuwien.infosys.aic11.data.Address adr = new at.ac.tuwien.infosys.aic11.data.Address();
		adr.setId(Long.parseLong(inputLineFromCli("AdressId: ")));
		adr.setStreet(inputLineFromCli("Street: "));
		adr.setCity(inputLineFromCli("City: "));
		adr.setDoor(inputLineFromCli("Door: "));
		adr.setHouse(inputLineFromCli("House: "));
		adr.setZipcode(inputLineFromCli("Zipcode: "));
		
		this.c.setAddress(adr);
		this.c.setOpenbalance(BigDecimal.valueOf(Long.parseLong(inputLineFromCli("Openbalance: "))));
		
		Rating rating = new Rating();
		rating.setCustomer(this.c);
		rating.setCustomerrating(getCustomerRating(this.c));
		this.c.setRating(rating);
    }
    
    private CreditRequest generateCreditRequest()
    {
    	CreditRequest creditRequest = new CreditRequest();
    	
    	creditRequest.setRequestid(Long.parseLong(inputLineFromCli("RequestId: ")));
    	creditRequest.setReason( inputLineFromCli("Reason: "));
    	creditRequest.setCustomer( this.c );
    	
    	
    	Duration  d = new Duration();
    	d.setYears(Integer.parseInt(inputLineFromCli("Duration in years: ")));
    	creditRequest.setDuration(d);
    	
    	Money m = new Money();
    	m.setAmount(Long.parseLong(inputLineFromCli("Amount: ")));
    	m.setCurrencycode(inputLineFromCli("Currencycode: "));
    	creditRequest.setMoney(m);
    	
    	// TODO add warrantors
    	Warrantor w = inputWarrantor();
    	
    	creditRequest.addWarrentee(w);
    	
    	return creditRequest;
    }
    
    private Warrantor inputWarrantor()
    {
    	Warrantor w = new Warrantor();
    	System.out.println("Creating Warrantor...");
    	
    	w.setFirstname(inputLineFromCli("Firstname: "));
    	w.setLastname(inputLineFromCli("Lastname: "));
    	//w.setDisbursementrating("Disbursementrating: ");
    	w.setMiddlename(inputLineFromCli("Middlename: "));
    	w.setOpenbalance(BigDecimal.valueOf(Long.parseLong(inputLineFromCli("Openbalance: "))));
    	//w.setRating("");
    	at.ac.tuwien.infosys.aic11.data.Address adr = new at.ac.tuwien.infosys.aic11.data.Address();
		adr.setId(Long.parseLong(inputLineFromCli("AdressId: ")));
		adr.setStreet(inputLineFromCli("Street: "));
		adr.setCity(inputLineFromCli("City: "));
		adr.setDoor(inputLineFromCli("Door: "));
		adr.setHouse(inputLineFromCli("House: "));
		adr.setZipcode(inputLineFromCli("Zipcode: "));
		
		w.setAddress(adr);
		
		Rating rating = new Rating();
		rating.setCustomer(w);
		rating.setCustomerrating(getCustomerRating(w));
		w.setRating(rating);
    	
    	return w;
    }
    
    private String inputLineFromCli(String text)
    {
		System.out.println(text);
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		String input = "";
		try {
			input = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input;
    }
    private String getStringFromInputStream(InputStream in) throws Exception {
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
        return bos.getOut().toString();
    }
    
    private CustomerRating getCustomerRating(Customer customer)
    {
    	String ratingRequest = "http://localhost:9001/ratingservice/rating/";
    	
        URL url;
		
		InputStream in = null;
		try {
			url = new URL(ratingRequest+customer.getCustomerid());
			in = url.openStream();        
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			return CustomerRating.valueOf(getStringFromInputStream(in));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return CustomerRating.Defaulting;
    }
}
