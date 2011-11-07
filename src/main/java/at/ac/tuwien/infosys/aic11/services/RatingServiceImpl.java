package at.ac.tuwien.infosys.aic11.services;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Rating;
import at.ac.tuwien.infosys.aic11.legacy.RatingInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.RatingMock;

public class RatingServiceImpl implements RatingService {
	
	RatingInterface ri = new RatingMock();
	
	public Rating getRating(CreditRequest cr) {
		return ri.getCustomerRating( cr );
	}
}