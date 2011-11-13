package at.ac.tuwien.infosys.aic11;

import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import at.ac.tuwien.infosys.aic11.services.ContractManagementService;
import at.ac.tuwien.infosys.aic11.services.ContractManagementServiceImpl;
import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementService;
import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl;
import at.ac.tuwien.infosys.aic11.services.RatingService;
import at.ac.tuwien.infosys.aic11.services.RatingServiceImpl;
import at.ac.tuwien.infosys.aic11.services.ShippingService;
import at.ac.tuwien.infosys.aic11.services.ShippingServiceImpl;

public class Server {
	private Logger logger;

	private Server() {
		logger = Logger.getLogger("at.ac.tuwien.infosys.aic11.Server");
	}

	private void startServer() throws Exception {
		logger.info("Starting server...");
		startCRService();
		startCrontractManagementService();
		startShippingService();
		startRatingService();
		logger.info("Server ready");

		System.in.read(); // wait for some input from console to exit server
		logger.info("Shutting down server");
	}

	private void startCRService() throws Exception {
		logger.info("Starting CustomerRelationsManagementService...");

		// WORKS
		CustomerRelationsManagementService crManagerImpl = new CustomerRelationsManagementServiceImpl();
		String address = "http://localhost:9000/CustomerRelationsManagementService";
		Endpoint.publish(address, crManagerImpl);

		// DOES NOT WORK
		/*
		 * JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		 * sf.setResourceClasses(CustomerRelationsManagementService.class);
		 * sf.setResourceProvider(CustomerRelationsManagementService.class, new
		 * SingletonResourceProvider(new
		 * CustomerRelationsManagementServiceImpl()));
		 * sf.setAddress("http://localhost:9000/CRService/");
		 * 
		 * sf.create();
		 */

		// DOES NOT WORK
		/*
		 * ServerFactoryBean svrFactory = new ServerFactoryBean();
		 * svrFactory.setServiceClass(CustomerRelationsManagementService.class);
		 * svrFactory.setAddress("http://localhost:9000/CRService/");
		 * svrFactory.setServiceBean(new
		 * CustomerRelationsManagementServiceImpl()); svrFactory.create();
		 */

		logger.info("CustomerRelationsManagementService running");
	}

	private void startRatingService() throws Exception {
		logger.info("Starting RatingService...");
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(RatingService.class);
		sf.setResourceProvider(RatingService.class,
				new SingletonResourceProvider(new RatingServiceImpl()));
		sf.setAddress("http://localhost:9001/");

		sf.create();
		logger.info("RatingService running");
	}
	
	private void startCrontractManagementService(){
		logger.info("Starting CrontractManagementService...");
		
		ContractManagementService cmManagerImpl = new ContractManagementServiceImpl();
		String address = "http://localhost:9002/CMService";
		Endpoint.publish(address, cmManagerImpl);

		logger.info("CrontractManagementService running");
	}
	private void startShippingService(){
		logger.info("Starting ShippingService...");
		
		ShippingService sManagerImpl = new ShippingServiceImpl();
		String address = "http://localhost:9003/ShippingService";
		Endpoint.publish(address, sManagerImpl);

		logger.info("ShippingService running");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new Server().startServer();
		System.exit(0);
	}

}
