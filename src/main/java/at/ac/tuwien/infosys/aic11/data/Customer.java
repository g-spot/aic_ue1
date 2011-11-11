package at.ac.tuwien.infosys.aic11.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="customer")
public class Customer {

    protected long customerid;
	protected String firstname;
	protected String middlename;
	protected String lastname;
	protected BigDecimal openbalance;
	
	protected Address address;
	protected DisbursementPreference disbursementpreference;
	protected List<CreditRequest> creditrequests = new ArrayList<CreditRequest>();
	protected Rating rating;
	
	@XmlAttribute
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public BigDecimal getOpenbalance() {
		return openbalance;
	}
	public void setOpenbalance(BigDecimal openbalance) {
		this.openbalance = openbalance;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public DisbursementPreference getDisbursementpreference() {
		return disbursementpreference;
	}
	public void setDisbursementrating(DisbursementPreference disbursementpreference) {
		this.disbursementpreference = disbursementpreference;
	}
	public List<CreditRequest> getCreditrequests() {
		return creditrequests;
	}
	public void setCreditrequests(List<CreditRequest> creditrequests) {
		this.creditrequests = creditrequests;
	}
	public void addCreditrequest( CreditRequest c ) {
		this.creditrequests.add( c );
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
}
