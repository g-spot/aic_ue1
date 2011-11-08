package at.ac.tuwien.infosys.aic11;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl;
import at.ac.tuwien.infosys.aic11.services.RatingService;
import at.ac.tuwien.infosys.aic11.services.RatingServiceImpl;

public class Server {
	
	protected static void StartCRServer() throws Exception {
		System.out.println("START DA FUCKIN CR MANAGEMENT SERVICE...");
		CustomerRelationsManagementServiceImpl crManagerImpl = new CustomerRelationsManagementServiceImpl();
		String address = "http://localhost:9000/CRService";
		Endpoint.publish(address, crManagerImpl);
	}
	
	protected static void StartRatingServer() throws Exception {
		System.out.println("START RATING SERVICE...");
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(RatingService.class);
		sf.setResourceProvider(RatingService.class,
								new SingletonResourceProvider(new RatingServiceImpl()));
		sf.setAddress("http://localhost:9001/");
		
		sf.create();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Server.StartCRServer();
		Server.StartRatingServer();
		System.out.println("Server ready...");
		
		Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
	}

}
