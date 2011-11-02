package src.at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

import src.at.ac.tuwien.infosys.aic11.data.Customer;

@WebService(targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public interface CustomerRelationsManagementService {
	
	public Customer addCustomer( Customer c );
}
