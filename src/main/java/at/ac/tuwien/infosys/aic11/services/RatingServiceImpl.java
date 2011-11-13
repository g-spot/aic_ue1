package at.ac.tuwien.infosys.aic11.services;

import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.Rating;
import at.ac.tuwien.infosys.aic11.legacy.CustomerInterface;
import at.ac.tuwien.infosys.aic11.legacy.RatingInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.CustomerMock;
import at.ac.tuwien.infosys.aic11.legacy.mock.RatingMock;

public class RatingServiceImpl implements RatingService {
	
	CustomerInterface ci = CustomerMock.getInstance();
	RatingInterface ri = RatingMock.getInstance();
	
	public Rating getRating( @PathParam("id") long id ) {
		Customer customer = ci.getCustomer( id );
		
		if(customer == null)
			throw new WebApplicationException( Response.status(-1).entity(new String("unknown Customer")).build() );

		return ri.getRating(customer);
	}
}