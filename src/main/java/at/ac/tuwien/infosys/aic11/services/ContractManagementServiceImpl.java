package at.ac.tuwien.infosys.aic11.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.apache.cxf.feature.Features;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestDTO;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestMarshaller;
import at.ac.tuwien.infosys.aic11.legacy.ContractInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.ContractMock;

@WebService( targetNamespace = "http://at.ac.tuwien.infosys.aic11.services" )
@Features( features = "org.apache.cxf.feature.LoggingFeature" )
@InInterceptors( interceptors = "at.ac.tuwien.infosys.aic11.services.security.SecurityInInterceptor" )
@OutInterceptors( interceptors = "at.ac.tuwien.infosys.aic11.services.security.SecurityOutInterceptor" )
public class ContractManagementServiceImpl implements ContractManagementService {

	ContractInterface ci = ContractMock.getInstance();
	
	@WebMethod
	@Consumes("application/xml")
	@Produces("application/xml")
	public CreditRequest generateCreditRequestOffer(CreditRequest cr) {
		return ci.generateCreditRequestOffer( cr );
	}

	@WebMethod
	@Consumes("application/xml")
	public void updateCreditRequest(CreditRequest cr) {
		ci.updateCreditRequest( cr );
	}

	@WebMethod
	@Consumes("application/xml")
	public void declineOffer(CreditRequestDTO cr) {
		ci.declineOffer( CreditRequestMarshaller.unmarshall( cr ) );
	}
}