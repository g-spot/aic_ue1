package src.at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import src.at.ac.tuwien.infosys.aic11.data.CreditRequest;

@WebService(targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
//TODO ENCRYPT
public class ContractManagementServiceImpl implements ContractManagementService {

	@Override
	@WebMethod
	public CreditRequest generateCreditRequestOffer(CreditRequest cr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod
	public void updateCreditRequest(CreditRequest cr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@WebMethod
	public void acceptOffer(CreditRequest cr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@WebMethod
	public void declineOffer(CreditRequest cr) {
		// TODO Auto-generated method stub
		
	}
}