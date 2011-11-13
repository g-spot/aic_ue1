package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.legacy.CustomerInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.CustomerMock;

@WebService(serviceName = "CustomerRelationsManagementService",
portName = "CustomerRelationsManagementServicePort",
endpointInterface = "at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementService")
public class CustomerRelationsManagementServiceImpl implements
		CustomerRelationsManagementService {

	CustomerInterface ci = CustomerMock.getInstance();

	public void addCustomer(Customer c) {
		ci.addCustomer(c);
	}

}
