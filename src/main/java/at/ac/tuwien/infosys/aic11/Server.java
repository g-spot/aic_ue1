package at.ac.tuwien.infosys.aic11;

import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl;
import at.ac.tuwien.infosys.aic11.services.RatingService;
import at.ac.tuwien.infosys.aic11.services.RatingServiceImpl;

public class Server {
	private Logger logger;

	private Server() {
		logger = Logger.getLogger("at.ac.tuwien.infosys.aic11.Server");
	}

	private void startServer() throws Exception {
		logger.info("Starting server...");
		startCRService();
		startRatingService();
		logger.info("Server ready");

		System.in.read(); // wait for some input from console to exit server
		logger.info("Shutting down server");
	}

	private void startCRService() throws Exception {
		logger.info("Starting CustomerRelationsManagementService...");

		// WORKS
		CustomerRelationsManagementServiceImpl crManagerImpl = new CustomerRelationsManagementServiceImpl();
		String address = "http://localhost:9000/CRService";
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

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new Server().startServer();
		System.exit(0);
	}

}
