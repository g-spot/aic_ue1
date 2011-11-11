package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;

import org.apache.cxf.feature.Features;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.legacy.CustomerInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.CustomerMock;

@WebService(targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerRelationsManagementServiceImpl implements
		CustomerRelationsManagementService {

	CustomerInterface ci = CustomerMock.getInstance();

	@WebMethod
	@Consumes("application/xml")
	public void addCustomer(Customer c) {
		ci.addCustomer(c);
	}

}
