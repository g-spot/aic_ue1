package src.at.ac.tuwien.infosys.aic11.services;

import src.at.ac.tuwien.infosys.aic11.data.CreditRequest;
import src.at.ac.tuwien.infosys.aic11.data.Rating;
import src.at.ac.tuwien.infosys.aic11.legacy.RatingInterface;
import src.at.ac.tuwien.infosys.aic11.legacy.mock.RatingMock;

public class RatingServiceImpl implements RatingService {
	
	RatingInterface ri = new RatingMock();
	
	@Override
	public Rating getRating(CreditRequest cr) {
		return ri.getCustomerRating( cr );
	}
}