package at.ac.tuwien.infosys.aic11.services;

import java.util.logging.Logger;

import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.legacy.CustomerInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.CustomerMock;


@WebService(serviceName = "CustomerRelationsManagementService",
			portName = "CustomerRelationsManagementServicePort",
			endpointInterface = "at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementService")
public class CustomerRelationsManagementServiceImpl implements CustomerRelationsManagementService {
	
	private Logger logger;
	private CustomerInterface ci;
	
	public CustomerRelationsManagementServiceImpl()
	{
		ci = CustomerMock.getInstance();
		logger = Logger.getLogger("at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl");
	}
	
	public void addCustomer(Customer c) {
		logger.info("Invoking addCustomer(c = " + c + ")");
		ci.addCustomer(c);
		logger.info("Finishing addCustomer (no return value)");
	}

}
