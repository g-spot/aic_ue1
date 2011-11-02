package src.at.ac.tuwien.infosys.aic11.legacy;

import src.at.ac.tuwien.infosys.aic11.data.CreditRequest;

public interface ContractInterface {

	public CreditRequest generateCreditRequestOffer( CreditRequest cr );
	public void updateCreditRequest( CreditRequest cr );
	public void acceptOffer( CreditRequest cr );
	public void declineOffer( CreditRequest cr );
	
}
