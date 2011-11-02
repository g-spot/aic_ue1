package src.at.ac.tuwien.infosys.aic11.services;

import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;

import src.at.ac.tuwien.infosys.aic11.data.Customer;

@WebService(targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public class CustomerRelationsManagementServiceImpl implements CustomerRelationsManagementService {
	
	private Logger logger;
	
	public CustomerRelationsManagementServiceImpl()
	{
		logger = Logger.getLogger("at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl");
	}
	
	@Override
	@WebMethod
	public Customer addCustomer(Customer c) {
		logger.info("Invoking addCustomer(c = " + c + ")");
		// TODO Auto-generated method stub
		logger.info("Finishing addCustomer (return value = null)");
		return null;
	}

}
