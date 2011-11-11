package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;

import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestDTO;

@WebService(targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public interface ShippingService {

	@WebMethod
	@Consumes("application/xml")
	public void acceptOffer( CreditRequestDTO cr );
}
