package at.ac.tuwien.infosys.aic11.data;

import java.util.ArrayList;
import java.util.List;

public class Warrantor extends Customer {

	protected List<CreditRequest> creditrequests = new ArrayList<CreditRequest>();

	public List<CreditRequest> getCreditrequests() {
		return creditrequests;
	}

	public void setCreditrequests(List<CreditRequest> credits) {
		this.creditrequests = credits;
	}
	
	public void addCreditrequest( CreditRequest c ) {
		this.creditrequests.add( c );
	}
}
