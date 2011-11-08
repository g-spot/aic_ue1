package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.data.Customer;


@WebService(name = "CustomerRelationsManagementService",
			targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public interface CustomerRelationsManagementService {
	
	@WebMethod
	public void addCustomer(@WebParam(name="customer")Customer c );
}
