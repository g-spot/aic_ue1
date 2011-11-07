package at.ac.tuwien.infosys.aic11.services;

import java.util.logging.Logger;

import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.data.Customer;


@WebService(serviceName = "CustomerRelationsManagementService",
			portName = "CustomerRelationsManagementServicePort",
			endpointInterface = "at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementService")
public class CustomerRelationsManagementServiceImpl implements CustomerRelationsManagementService {
	
	private Logger logger;
	
	public CustomerRelationsManagementServiceImpl()
	{
		logger = Logger.getLogger("at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl");
	}
	
	public Customer addCustomer(Customer c) {
		logger.info("Invoking addCustomer(c = " + c + ")");
		Customer customer = new Customer();
		customer.setFirstname("Gaylord");
		customer.setLastname("Focker");
		logger.info("Finishing addCustomer (return value = null)");
		return customer;
	}

}
