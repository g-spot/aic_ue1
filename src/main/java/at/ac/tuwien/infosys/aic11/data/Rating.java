package at.ac.tuwien.infosys.aic11.data;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Rating")
public class Rating {
	
	private CustomerRating customerrating;
	private Customer customer;
	
	public Rating (){
		
	}
	
	public Rating( Customer c ) {
		this.customer = c;
	}

	public CustomerRating getCustomerrating() {
		return customerrating;
	}

	public void setCustomerrating(CustomerRating customerrating) {
		this.customerrating = customerrating;
	}

	@XmlTransient // prevents the mapping of the property to xml representation
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer c) {
		this.customer = c;
	}
}
