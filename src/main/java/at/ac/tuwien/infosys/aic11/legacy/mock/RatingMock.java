package at.ac.tuwien.infosys.aic11.legacy.mock;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.CustomerRating;
import at.ac.tuwien.infosys.aic11.data.Rating;
import at.ac.tuwien.infosys.aic11.legacy.RatingInterface;

public class RatingMock implements RatingInterface {
	
    private static RatingMock instance;

    private RatingMock() {}

    public synchronized static RatingMock getInstance() 
    {
        if (instance == null) 
        {
            instance = new RatingMock();
        }
        return instance;
    }

	/*public Rating getCustomerRating(CreditRequest cr) {
		//what to do with the ratings...
		for( Warrantor w : cr.getWarrantees() )
			w.getRating();
		
		return cr.getCustomer().getRating();
	}*/
	
	public Rating getRating(Customer c) {
		// ratings are defined by the last name of the customer/warrantor:
		// * is the last name "Bankrupt", Rating AMinus is returned
		// * is the last name "Reliable", Rating AAA is returned
		// * otherwise Rating A is returned
		Rating result = new Rating(c);
		if(c.getLastname().equals("Bankrupt"))
			result.setCustomerrating(CustomerRating.AMinus);
		else if(c.getLastname().equals("Reliable"))
			result.setCustomerrating(CustomerRating.AAA);
		else
			result.setCustomerrating(CustomerRating.A);
		return result;
	}
	
}

