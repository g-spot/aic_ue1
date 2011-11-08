package at.ac.tuwien.infosys.aic11.legacy.mock;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.Warrantor;
import at.ac.tuwien.infosys.aic11.legacy.CustomerInterface;

public class CustomerMock implements CustomerInterface {
	
	private Map<Long, Customer> customers;
	
	public CustomerMock() {
		//TODO Mock data
		fillCustomers();
	}

	public void addCustomer(Customer c) {
		customers.put(c.getCustomerid(), c);
	}

	public Customer getCustomer(long id) {
		return customers.get(id);
	}
	
	private void fillCustomers() {
		Object[][] mockCustomers = {
			{(long)101, "Frank", "Bankrupt"},
			{(long)102, "Joe", "Reliable"},
			{(long)103, "Steve", "Normal"}
		};
		Object[][] mockWarrantors = {
				{(long)201, "David", "Normal"},
				{(long)202, "John", "Bankrupt"},
				{(long)203, "George", "Reliable"}
			};
		
		customers = new HashMap<Long, Customer>();
		for(int i=0;i<mockCustomers.length;i++) {
			Customer c = new Customer();
			c.setCustomerid((Long)mockCustomers[i][0]);
			c.setFirstname((String)mockCustomers[i][1]);
			c.setLastname((String)mockCustomers[i][2]);
			customers.put((Long)mockCustomers[i][0], c);
		}
		for(int i=0;i<mockWarrantors.length;i++) {
			Warrantor w = new Warrantor();
			w.setCustomerid((Long)mockWarrantors[i][0]);
			w.setFirstname((String)mockWarrantors[i][1]);
			w.setLastname((String)mockWarrantors[i][2]);
			customers.put((Long)mockWarrantors[i][0], w);
		}
	}

}
