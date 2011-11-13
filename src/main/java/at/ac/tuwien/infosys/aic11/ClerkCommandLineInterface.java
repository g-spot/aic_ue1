package at.ac.tuwien.infosys.aic11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.legacy.mock.CustomerMock;
import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementService;

public class ClerkCommandLineInterface {
	private QName service_name;
	private QName port_name ;
	private String address;
	private JaxWsProxyFactoryBean factory;
	private CustomerRelationsManagementService cr;
	private Customer c;
	private CustomerMock cm;

	
	public ClerkCommandLineInterface(){
		this.service_name = new QName("http://services.aic11.infosys.tuwien.ac.at/", "CustomerRelationsManagementService");
		this.port_name = new QName("http://services.aic11.infosys.tuwien.ac.at/", "CustomerRelationsManagementServicePort");
		this.address = "http://localhost:9000/CRService";
		
		
		this.factory = new JaxWsProxyFactoryBean();
		
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(CustomerRelationsManagementService.class);
		factory.setAddress(address);
		
	    this.cr = (CustomerRelationsManagementService)factory.create();
	    this.cm = CustomerMock.getInstance();
		
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
    	
    	// TODO check already done points to avoid missing dependencies on following
    	// TODO call only inputs in menu that are needed to complete (create customer -> create offer -> update offer -> accept / declain)
    	
    	menuString += "Please select one of the following options: \n\r";
    	menuString += "===========================================\n\r\n\r";
    	menuString += "(1) create customer\n\r"; // create new customer or select from existing mock up
    	menuString += "(2) create credit request\n\r"; // create request and fill with data
    	menuString += "(3) update request\n\r"; // change data here
    	menuString += "(4) accept\n\r"; // disbursement + shipping in thread each
    	menuString += "(5) decline\n\r"; // remove only
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
    				returnString = "Customer selected.\n\r";
    			break;
    		
    		case 2:
    				// TODO CREATE REQUEST but check if customer is set!
    				returnString = "Credit request created.\n\r";
    			break;
    		case 3:
    				// TODO update REQUEST but check if customer is set!
    				returnString = "Credit request updated.\n\r";
    			break;
    			
    		case 4:
    				// TODO accept request 
    				returnString = "Accapted offer - shipping contract and sending disbursement.\n\r";
    			break;
    		case 5:
    				// TODO call remove
    				returnString = "Declined offer - deleted offer from the system. \n\r";
    			break;
    		default:
    			returnString = "Unknown selection!\n\r";
    	}
    	return returnString;
    }
    
    private void generateCreateCustomerInteraction()
    {
    	// print customers to select or select to create new
    	String menuString = "";
    	String selection = "";
    	String selectedId = "";
    	
    	menuString += "Please choose: \n\r";
    	menuString += "==============\n\r\n\r";
    	menuString += "(1) create customer\n\r";
    	menuString += "(2) select existing\n\r";
    	
    	while(!selection.equals("1") && !selection.equals("2"))
    	{
	    	selection = menuCall(menuString);
	    	if(selection.equals("1"))
	    	{
	       		// create new customer
	    			this.c = new Customer();
	    			
	    			// input new customer
	    			c.setCustomerid(Long.parseLong(inputLineFromCli("CustomerID: ")));
	    			c.setFirstname(inputLineFromCli("First name: "));
	    			c.setLastname(inputLineFromCli("Last name: "));
	    			cr.addCustomer(c);
	    	}
	    	else if(selection.equals("2"))
	    	{
	    		// get customer from mock?
	    		selectedId = inputLineFromCli("CostumerId: ");
	    		c = cm.getCustomer(Long.parseLong(selectedId));
	    	}
	    	else
	    	{
	    		menuString += "Wrong input please use the Number inside the round brackets!\n\r";
	    	}
    	}	
    }
    
    private CreditRequest generateCreditRequest()
    {
    	CreditRequest creditRequest = new CreditRequest();
    	
    	//TODO check what has to be done here
    	
    	return creditRequest;
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
    
    private String getCustomerRating()
    {
    	String ratingRequest = "http://localhost:9001/ratingservice/rating/";
    	
        // get rating of customer with id 202
    	
        URL url;
		
		InputStream in = null;
		try {
			url = new URL(ratingRequest+c.getCustomerid());
			in = url.openStream();        
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			return getStringFromInputStream(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "110";
    }
    private String getWarrantorRating()
    {
    	String rating = "";
    	String ratingRequest = "http://localhost:9001/ratingservice/rating/";
    	
    	return rating; 
    }
}
