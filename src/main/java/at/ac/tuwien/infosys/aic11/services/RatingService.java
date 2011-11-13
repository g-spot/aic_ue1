package at.ac.tuwien.infosys.aic11.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.cxf.annotations.Logging;

import at.ac.tuwien.infosys.aic11.data.Rating;

@Path("/ratingservice/")
//@Features( features = "at.ac.tuwien.infosys.aic11.services.logging.Logger" )//features = "org.apache.cxf.feature.LoggingFeature" )
//@InInterceptors( interceptors="at.ac.tuwien.infosys.aic11.services.logging.InLogger" )
@Logging
public interface RatingService {
	
	/**
	 * @return returns the Rating for a customer
	 */
	@GET
	@Produces("application/json")
	@Path("/rating/{id}/")
	public Rating getRating( @PathParam("id") long id );
	
}