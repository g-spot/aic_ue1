package at.ac.tuwien.infosys.aic11.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.cxf.interceptor.OutInterceptors;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Rating;


//@OutInterceptors( interceptors={ "RatingOutInterceptor" } )
@Path("/ratingservice/")
public interface RatingService {
	
	/**
	 * @return returns the Rating for a customer
	 */
	@GET
	@Produces("application/json")
	@Path("/rating/{id}/")
	public Rating getRating(@PathParam("id") String id);
}