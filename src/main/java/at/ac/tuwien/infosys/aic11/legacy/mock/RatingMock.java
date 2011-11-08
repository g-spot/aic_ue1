package at.ac.tuwien.infosys.aic11.legacy.mock;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.CustomerRating;
import at.ac.tuwien.infosys.aic11.data.Rating;
import at.ac.tuwien.infosys.aic11.data.Warrantor;
import at.ac.tuwien.infosys.aic11.legacy.RatingInterface;

public class RatingMock implements RatingInterface {

	/*public Rating getCustomerRating(CreditRequest cr) {
		//what to do with the ratings...
		for( Warrantor w : cr.getWarrantees() )
			w.getRating();
		
		return cr.getCustomer().getRating();
	}*/
	
	public Rating getRating(Customer c) {
		//TODO add kind of logic for ratings
		Rating result = new Rating(c);
		if(c.getLastname().equals("Bankrupt"))
			result.setCustomerrating(CustomerRating.AMinus);
		else
			result.setCustomerrating(CustomerRating.AAA);
		return result;
	}
	
}

