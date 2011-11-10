package at.ac.tuwien.infosys.aic11.data.dtos;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.legacy.mock.CustomerMock;

public class CustomerMarshaller {

	public static CustomerDTO marshall( Customer c ) {
		return new CustomerDTO( c.getCustomerid() );
	}
	
	public static Customer unmarshall( CustomerDTO cdto ) {
		return CustomerMock.getInstance().getCustomer( cdto.getCustomerId() );
	}
}
