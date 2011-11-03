package at.ac.tuwien.infosys.aic11.data;

public class Rating {
	
	private CustomerRating customerrating;
	private Customer customer;
	
	public Rating( Customer c ) {
		this.customer = c;
	}

	public CustomerRating getCustomerrating() {
		return customerrating;
	}

	public void setCustomerrating(CustomerRating customerrating) {
		this.customerrating = customerrating;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer c) {
		this.customer = c;
	}
}
