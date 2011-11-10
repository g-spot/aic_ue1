package at.ac.tuwien.infosys.aic11.legacy.mock;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.infosys.aic11.data.Address;
import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.Warrantor;
import at.ac.tuwien.infosys.aic11.legacy.CustomerInterface;

public class CustomerMock implements CustomerInterface {
	
	private Map<Long, Customer> customers;
	
	private static CustomerMock instance;

    private CustomerMock() {
    	fillCustomers();
    }

    public synchronized static CustomerMock getInstance() 
    {
        if (instance == null) 
        {
            instance = new CustomerMock();
        }
        return instance;
    }

	public long addCustomer(Customer c) {
		c.setCustomerid( customers.size() );
		customers.put( c.getCustomerid(), c );
		return c.getCustomerid();
	}

	public Customer getCustomer(long id) {
		return customers.get(id);
	}
	
	private void fillCustomers() {
		Object[][] mockCustomers = {
			{(long)101, "Frank", "Bankrupt", (long)301, "Resselpark", "Vienna", "50", "7a", "1040"},
			{(long)102, "Joe", "Reliable", (long)302, "Resselpark", "Vienna", "50", "7a", "1040"},
			{(long)103, "Steve", "Normal", (long)303, "Resselpark", "Vienna", "50", "7a", "1040"}
		};
		Object[][] mockWarrantors = {
				{(long)201, "David", "Normal", (long)304, "Resselpark", "Vienna", "50", "7a", "1040"},
				{(long)202, "John", "Bankrupt", (long)305, "Resselpark", "Vienna", "50", "7a", "1040"},
				{(long)203, "George", "Reliable", (long)306, "Resselpark", "Vienna", "50", "7a", "1040"}
			};
		
		customers = new HashMap<Long, Customer>();
		for(int i=0;i<mockCustomers.length;i++) {
			Customer c = new Customer();
			c.setCustomerid((Long)mockCustomers[i][0]);
			c.setFirstname((String)mockCustomers[i][1]);
			c.setLastname((String)mockCustomers[i][2]);
			Address a = new Address();
			a.setId((Long)mockCustomers[i][3]);
			a.setStreet((String)mockCustomers[i][4]);
			a.setCity((String)mockCustomers[i][5]);
			a.setHouse((String)mockCustomers[i][6]);
			a.setDoor((String)mockCustomers[i][7]);
			a.setZipcode((String)mockCustomers[i][8]);
			c.setAddress(a);
			customers.put((Long)mockCustomers[i][0], c);
		}
		for(int i=0;i<mockWarrantors.length;i++) {
			Warrantor w = new Warrantor();
			w.setCustomerid((Long)mockWarrantors[i][0]);
			w.setFirstname((String)mockWarrantors[i][1]);
			w.setLastname((String)mockWarrantors[i][2]);
			Address a = new Address();
			a.setId((Long)mockWarrantors[i][3]);
			a.setStreet((String)mockWarrantors[i][4]);
			a.setCity((String)mockWarrantors[i][5]);
			a.setHouse((String)mockWarrantors[i][6]);
			a.setDoor((String)mockWarrantors[i][7]);
			a.setZipcode((String)mockWarrantors[i][8]);
			w.setAddress(a);
			customers.put((Long)mockWarrantors[i][0], w);
		}
	}

}
