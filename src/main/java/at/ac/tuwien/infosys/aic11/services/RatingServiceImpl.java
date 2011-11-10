package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.cxf.feature.Features;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.Rating;
import at.ac.tuwien.infosys.aic11.legacy.CustomerInterface;
import at.ac.tuwien.infosys.aic11.legacy.RatingInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.CustomerMock;
import at.ac.tuwien.infosys.aic11.legacy.mock.RatingMock;

@WebService(targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
@Path("/ratingservice/")
@Features( features = "org.apache.cxf.feature.LoggingFeature" )
public class RatingServiceImpl implements RatingService {
	
	CustomerInterface ci = CustomerMock.getInstance();
	RatingInterface ri = RatingMock.getInstance();
	
	@GET
	@Produces("application/json")
	@Path("/rating/{id}/")
	public Rating getRating( @PathParam("id") long id ) {
		Customer customer = ci.getCustomer( id );
		
		if(customer == null)
			throw new WebApplicationException( Response.status(-1).entity(new String("unknown Customer")).build() );

		return ri.getRating(customer);
	}
}