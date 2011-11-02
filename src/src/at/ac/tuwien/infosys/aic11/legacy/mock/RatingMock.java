package src.at.ac.tuwien.infosys.aic11.legacy.mock;

import src.at.ac.tuwien.infosys.aic11.data.CreditRequest;
import src.at.ac.tuwien.infosys.aic11.data.Rating;
import src.at.ac.tuwien.infosys.aic11.data.Warrantor;
import src.at.ac.tuwien.infosys.aic11.legacy.RatingInterface;

public class RatingMock implements RatingInterface {

	@Override
	public Rating getCustomerRating(CreditRequest cr) {
		//what to do with the ratings...
		for( Warrantor w : cr.getWarrantees() )
			w.getRating();
		
		return cr.getCustomer().getRating();
	}
	
}
