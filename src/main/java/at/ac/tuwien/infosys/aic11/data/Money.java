package at.ac.tuwien.infosys.aic11.data;

public class Money {

	private String currencycode;
	private long amount;
	
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public at.ac.tuwien.infosys.aic11.services.Money toMoney() {
		at.ac.tuwien.infosys.aic11.services.Money m = new at.ac.tuwien.infosys.aic11.services.Money();
		m.setAmount( this.amount );
		m.setCurrencyCode( this.currencycode );
		return m;
	}
}
