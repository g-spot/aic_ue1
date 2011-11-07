package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;


@WebService(targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public interface ShippingService {

	public void shipContract( CreditRequest cr );
}
