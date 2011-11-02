package src.at.ac.tuwien.infosys.aic11.legacy;

import src.at.ac.tuwien.infosys.aic11.data.CreditRequest;
import src.at.ac.tuwien.infosys.aic11.data.Rating;

public interface RatingInterface {

	public Rating getCustomerRating( CreditRequest cr );
}
