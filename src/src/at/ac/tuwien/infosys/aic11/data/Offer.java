package src.at.ac.tuwien.infosys.aic11.data;

public class Offer {

	private long offerid;
	private String comments;
	private CreditRequest creditrequest;
	private InterestRate offer;
	
	
	public long getOfferid() {
		return offerid;
	}
	public void setOfferid(long offerid) {
		this.offerid = offerid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public CreditRequest getCreditrequest() {
		return creditrequest;
	}
	public void setCreditrequest(CreditRequest creditrequest) {
		this.creditrequest = creditrequest;
	}
	public InterestRate getOffer() {
		return offer;
	}
	public void setOffer(InterestRate offer) {
		this.offer = offer;
	}
}
