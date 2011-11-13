package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.apache.cxf.annotations.Logging;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestDTO;

@WebService(serviceName = "CustomerRelationsManagementService",
		portName = "ContractManagementServicePort",
		endpointInterface = "at.ac.tuwien.infosys.aic11.services.ContractManagementService")
@Logging
@InInterceptors( interceptors = "at.ac.tuwien.infosys.aic11.services.security.visualisation.ShowEncryptedMessage;at.ac.tuwien.infosys.aic11.services.security.SecurityInInterceptor;at.ac.tuwien.infosys.aic11.services.security.visualisation.ShowDecryptedMessage" )
@OutInterceptors( interceptors = "at.ac.tuwien.infosys.aic11.services.security.SecurityOutInterceptor" )
public interface ContractManagementService {

	@WebMethod
	@Consumes("application/xml")
	@Produces("application/xml")
	public CreditRequest generateCreditRequestOffer( CreditRequest cr );
	
	@WebMethod
	@Consumes("application/xml")
	public void updateCreditRequest( CreditRequest cr );
	
	@WebMethod
	@Consumes("application/xml")
	public void declineOffer( CreditRequestDTO cr );
	
}
