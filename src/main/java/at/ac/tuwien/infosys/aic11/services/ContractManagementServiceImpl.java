package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;



//TODO ENCRYPT
public class ContractManagementServiceImpl implements ContractManagementService {

	@WebMethod
	public CreditRequest generateCreditRequestOffer(CreditRequest cr) {
		// TODO Auto-generated method stub
		return null;
	}

	@WebMethod
	public void updateCreditRequest(CreditRequest cr) {
		// TODO Auto-generated method stub
		
	}

	@WebMethod
	public void acceptOffer(CreditRequest cr) {
		// TODO Auto-generated method stub
		
	}

	@WebMethod
	public void declineOffer(CreditRequest cr) {
		// TODO Auto-generated method stub
		
	}
}