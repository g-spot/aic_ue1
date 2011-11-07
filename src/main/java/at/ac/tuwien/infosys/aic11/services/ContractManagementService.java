package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;

@WebService(targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public interface ContractManagementService {

	@WebMethod
	public CreditRequest generateCreditRequestOffer( CreditRequest cr );
	
	@WebMethod
	public void updateCreditRequest( CreditRequest cr );
	
	@WebMethod
	public void acceptOffer( CreditRequest cr );
	
	@WebMethod
	public void declineOffer( CreditRequest cr );
	
}
