package at.ac.tuwien.infosys.aic11;

import java.io.InputStream;
import java.net.URL;

import javax.xml.namespace.QName;

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

    	
    	// Sent HTTP GET request to query customer info
        System.out.println("Send HTTP GET request to query customer info");
       
    	
        //TODO SHORTY: for contractmanagementservice calls ->
        //TODO SHORTY: factory.getInInterceptors().add(new SecurityInInterceptor());
    	//TODO SHORTY: factory.getOutInterceptors().add(new SecurityOutInterceptor());
        
    	//Thread.sleep(10000);
    }
    

    
}
