package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestDTO;

@WebService(serviceName = "CustomerRelationsManagementService",
		portName = "ContractManagementServicePort",
		endpointInterface = "at.ac.tuwien.infosys.aic11.services.ContractManagementService")
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
