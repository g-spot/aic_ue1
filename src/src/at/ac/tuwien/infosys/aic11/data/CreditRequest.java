package src.at.ac.tuwien.infosys.aic11.data;

import java.util.ArrayList;
import java.util.List;

public class CreditRequest {

	private long requestid;
	private String reason;
	private Customer customer;
	private List<Warrantor> warrantees = new ArrayList<Warrantor>();
	private Duration duration;
	private Money money;
	private Offer offer;
	
	public long getRequestid() {
		return requestid;
	}
	
	public void setRequestid(long requestid) {
		this.requestid = requestid;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Warrantor> getWarrantees() {
		return warrantees;
	}
	
	public void setWarrantees(List<Warrantor> warrantees) {
		this.warrantees = warrantees;
	}
	
	public void addWarrentee( Warrantor w ) {
		this.warrantees.add( w );
	}
	
	public Duration getDuration() {
		return duration;
	}
	
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	public Money getMoney() {
		return money;
	}
	
	public void setMoney(Money money) {
		this.money = money;
	}
	
	public Offer getOffer() {
		return offer;
	}
	
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
}
