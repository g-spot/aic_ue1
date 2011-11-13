package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;

import org.apache.cxf.annotations.Logging;

import at.ac.tuwien.infosys.aic11.data.Customer;



@Logging
public interface CustomerRelationsManagementService {
	
	@WebMethod
	@Consumes( "application/xml" )
	public void addCustomer( Customer c );
}
