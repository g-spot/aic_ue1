package at.ac.tuwien.infosys.aic11.legacy;

import at.ac.tuwien.infosys.aic11.data.Customer;

public interface CustomerInterface {

	public long addCustomer( Customer c );
	public Customer getCustomer(long id);
}
