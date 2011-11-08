package at.ac.tuwien.infosys.aic11.services;

import java.util.logging.Logger;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.Rating;
import at.ac.tuwien.infosys.aic11.legacy.CustomerInterface;
import at.ac.tuwien.infosys.aic11.legacy.RatingInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.CustomerMock;
import at.ac.tuwien.infosys.aic11.legacy.mock.RatingMock;

public class RatingServiceImpl implements RatingService {
	
	private RatingInterface ri;
	private CustomerInterface ci;
	private Logger logger;
	
	public RatingServiceImpl()
	{
		logger = Logger.getLogger("at.ac.tuwien.infosys.aic11.services.RatingServiceImpl");
		ri = new RatingMock();
		ci = new CustomerMock();
	}
	
	/*public Rating getRating(CreditRequest cr) {
		return ri.getCustomerRating( cr );
	}*/

	public Rating getRating(String id) {
		logger.info("Invoking getRating(id = " + id + ")");
		Customer customer = ci.getCustomer(Long.parseLong(id));
		if(customer == null)
			logger.info("CUSTOMER IS NULL");
		else
			logger.info("CUSTOMER FOUND: " + customer.getLastname());
		Rating rating = ri.getRating(customer);
		if(rating == null)
			logger.info("RATING IS NULL");
		else
			logger.info("Finishing getRating (return value = " + rating.getCustomerrating());
		return rating;
	}
}