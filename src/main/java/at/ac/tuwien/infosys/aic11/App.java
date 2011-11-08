package at.ac.tuwien.infosys.aic11;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	QName service_name = new QName("http://services.aic11.infosys.tuwien.ac.at/", "CustomerRelationsManagementService");
    	QName port_name = new QName("http://services.aic11.infosys.tuwien.ac.at/", "CustomerRelationsManagementServicePort");
    	String address = "http://localhost:9000/CRService";

    	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
    	factory.getInInterceptors().add(new LoggingInInterceptor());
    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
    	factory.setServiceClass(CustomerRelationsManagementService.class);
    	factory.setAddress(address);

        CustomerRelationsManagementService cr = (CustomerRelationsManagementService)factory.create();
    	
    	Customer c = new Customer();
    	c.setCustomerid(110);
    	c.setFirstname("Gerhard");
    	c.setLastname("Reliable");
    	cr.addCustomer(c);
    	
    	// Sent HTTP GET request to query customer info
        System.out.println("Send HTTP GET request to query customer info");
        
        // get rating of customer with id 202
        URL url = new URL("http://localhost:9001/ratingservice/rating/110");
        InputStream in = url.openStream();
        System.out.println(getStringFromInputStream(in));
    	
    	//Thread.sleep(10000);
    }
    
    private static String getStringFromInputStream(InputStream in) throws Exception {
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
        return bos.getOut().toString();
    }
}
