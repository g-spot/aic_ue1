package src.at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import src.at.ac.tuwien.infosys.aic11.data.Customer;

@WebService(targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public class CustomerRelationsManagementServiceImpl implements CustomerRelationsManagementService {

	@Override
	@WebMethod
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

}
