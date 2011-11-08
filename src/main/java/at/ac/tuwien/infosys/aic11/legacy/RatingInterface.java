package at.ac.tuwien.infosys.aic11.legacy;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.Rating;

public interface RatingInterface {

	//public Rating getCustomerRating( CreditRequest cr );
	public Rating getRating(Customer c);
}
