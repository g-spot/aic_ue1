package at.ac.tuwien.infosys.aic11.legacy.mock;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.legacy.CustomerInterface;

public class CustomerMock implements CustomerInterface {
	
	private Map<Long, Customer> customers;
	
	public CustomerMock() {
		//TODO Mock data
		customers = new HashMap<Long, Customer>();
		Customer c1 = new Customer();
		c1.setCustomerid(1234);
		c1.setFirstname("Frank");
		c1.setLastname("Bankrupt");
		customers.put((long)1234, c1);
	}

	public void addCustomer(Customer c) {
		customers.put(c.getCustomerid(), c);
	}

	public Customer getCustomer(long id) {
		return customers.get(id);
	}

}
