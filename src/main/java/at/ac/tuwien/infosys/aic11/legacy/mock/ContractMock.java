package at.ac.tuwien.infosys.aic11.legacy.mock;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.legacy.ContractInterface;

public class ContractMock implements ContractInterface {

	private Map< Long, CreditRequest> crs = new HashMap<Long, CreditRequest>();
	
	private static ContractMock instance;

    private ContractMock() {}

    public synchronized static ContractMock getInstance() 
    {
        if (instance == null) 
        {
            instance = new ContractMock();
        }
        return instance;
    }
    
	public CreditRequest generateCreditRequestOffer(CreditRequest cr) {
		cr.setRequestid( crs.size() );
		return cr;
	}

	public void updateCreditRequest(CreditRequest cr) {
		this.crs.put( cr.getRequestid(), cr );
	}

	public void acceptOffer(CreditRequest cr) {
		// TODO
	}

	public void declineOffer(CreditRequest cr) {
		this.crs.remove( cr.getRequestid() );
	}

	public CreditRequest getCreditRequestOffer(long id) {
		return this.crs.get( id );
	}
}
