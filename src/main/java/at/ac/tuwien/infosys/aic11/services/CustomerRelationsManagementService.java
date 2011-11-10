package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebParam;

import at.ac.tuwien.infosys.aic11.data.Customer;


public interface CustomerRelationsManagementService {
	
	public void addCustomer(@WebParam(name="customer")Customer c );
}
