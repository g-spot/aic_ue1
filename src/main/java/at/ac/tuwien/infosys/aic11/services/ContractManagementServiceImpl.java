package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestDTO;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestMarshaller;
import at.ac.tuwien.infosys.aic11.legacy.ContractInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.ContractMock;

@WebService(serviceName = "CustomerRelationsManagementService",
portName = "ContractManagementServicePort",
endpointInterface = "at.ac.tuwien.infosys.aic11.services.ContractManagementService")
public class ContractManagementServiceImpl implements ContractManagementService {

	ContractInterface ci = ContractMock.getInstance();
	
	public CreditRequest generateCreditRequestOffer(CreditRequest cr) {
		return ci.generateCreditRequestOffer( cr );
	}

	public void updateCreditRequest(CreditRequest cr) {
		ci.updateCreditRequest( cr );
	}

	public void declineOffer(CreditRequestDTO cr) {
		ci.declineOffer( CreditRequestMarshaller.unmarshall( cr ) );
	}
}