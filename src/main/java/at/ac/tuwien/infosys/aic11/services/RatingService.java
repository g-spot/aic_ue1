package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import at.ac.tuwien.infosys.aic11.data.Rating;

@Path("/ratingservice/")
public interface RatingService {
	
	/**
	 * @return returns the Rating for a customer
	 */
	@GET
	@Produces("application/json")
	@Path("/rating/{id}/")
	public Rating getRating( @PathParam("id") long id );
	
}