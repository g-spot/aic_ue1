package src.at.ac.tuwien.infosys.aic11.services;

import java.util.logging.Logger;

import src.at.ac.tuwien.infosys.aic11.data.Customer;

public class CustomerRelationsManagementServiceImpl implements CustomerRelationsManagementService {
	
	private Logger logger;
	
	public CustomerRelationsManagementServiceImpl()
	{
		logger = Logger.getLogger("at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl");
	}
	
	@Override
	public Customer addCustomer(Customer c) {
		logger.info("Invoking addCustomer(c = " + c + ")");
		// TODO Auto-generated method stub
		logger.info("Finishing addCustomer (return value = null)");
		return null;
	}

}
