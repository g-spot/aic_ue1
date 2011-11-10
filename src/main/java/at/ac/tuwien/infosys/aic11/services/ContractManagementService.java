package at.ac.tuwien.infosys.aic11.services;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestDTO;

public interface ContractManagementService {

	public CreditRequest generateCreditRequestOffer( CreditRequest cr );
	public void updateCreditRequest( CreditRequest cr );
	public void declineOffer( CreditRequestDTO cr );
	
}
