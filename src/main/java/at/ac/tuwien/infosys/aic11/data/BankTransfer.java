package at.ac.tuwien.infosys.aic11.data;

public class BankTransfer implements DisbursementPreference {

	private String bankname;
	private String bic;
	private String iban;
	
	public BankTransfer()
	{
		
	}
	
	
	public String getBankname() {
		return bankname;
	}


	public void setBankname(String bankname) {
		this.bankname = bankname;
	}


	public String getBic() {
		return bic;
	}


	public void setBic(String bic) {
		this.bic = bic;
	}


	public String getIban() {
		return iban;
	}


	public void setIban(String iban) {
		this.iban = iban;
	}


	@Override
	public String toString() {
		return "Bank Transfer: " + bankname + "; bic: " + bic + "; iban: " + iban;
	}
}
