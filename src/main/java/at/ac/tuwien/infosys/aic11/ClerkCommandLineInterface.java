package at.ac.tuwien.infosys.aic11;

import java.io.IOException;
import java.io.InputStream;
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
import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementService;

public class ClerkCommandLineInterface {
	private QName service_name;
	private QName port_name ;
	private String address;
	private JaxWsProxyFactoryBean factory;
	private CustomerRelationsManagementService cr;
	private Customer c;

	
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
		
		this.c = new Customer();
		c.setCustomerid(110);
		c.setFirstname("Gerhard");
		c.setLastname("Bankrupt");
		cr.addCustomer(c);
	}
	
    public String generateInputMenu()
    {
    	String menuString = new String();
    	
    	// TODO check already done points to avoid missing dependencies on following
    	
    	menuString += "Please select one of the following options: \n\r";
    	menuString += "===========================================\n\r\n\r";
    	menuString += "(1) Create credit request";
    	menuString += "(2) get ratings of customer and warrantors";
    	menuString += "(2) generate offer";
    	menuString += "(3) update request";
    	menuString += "(4) accept";
    	menuString += "(5) decline";
    	menuString += "(Q) Exit";
    	
    	return menuString;
    }
    
    private CreditRequest generateCreditRequest()
    {
    	CreditRequest creditRequest = new CreditRequest();
    	
    	//TODO check what has to be done here
    	
    	return creditRequest;
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
