package at.ac.tuwien.infosys.aic11.services;

import javax.ws.rs.GET;

import org.apache.cxf.interceptor.OutInterceptors;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Rating;


@OutInterceptors( interceptors={ "RatingOutInterceptor" } )
public interface RatingService {
	
	/**
	 * @return returns the Rating for a customer
	 */
	//wieso findet er die nicht? sollte im cxf drinnen sein
	@GET
//	@Path("/rating/") //wenn �ber interceptors wird der path dort gepr�ft
	Rating getRating( CreditRequest c );
}