package at.ac.tuwien.infosys.aic11.data.dtos;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.legacy.mock.ContractMock;

public class CreditRequestMarshaller {

	public static CreditRequestDTO marshall( CreditRequest cr ) {
		return new CreditRequestDTO( cr.getRequestid() );
	}
	
	public static CreditRequest unmarshall( CreditRequestDTO cr ) {
		return ContractMock.getInstance().getCreditRequestOffer( cr.getCreditRequestId() );
	}
}
