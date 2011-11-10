package at.ac.tuwien.infosys.aic11.services;

import at.ac.tuwien.infosys.aic11.data.Rating;


public interface RatingService {
	
	/**
	 * @return returns the Rating for a customer
	 */
	public Rating getRating(long id);
}