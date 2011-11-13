package at.ac.tuwien.infosys.aic11.data;

public class BankTransfer implements DisbursementPreference {

	private String bankname;
	private String bic;
	private String iban;
	
	public BankTransfer() {}
	
	public BankTransfer( at.ac.tuwien.infosys.aic11.services.BankTransfer bt ) {
		this.bankname = bt.getBankName();
		this.bic = bt.getBic();
		this.iban = bt.getIban();
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
	
	//STUPID university packaging causes the need for mapping and polutes our buisness objects
	public at.ac.tuwien.infosys.aic11.services.BankTransfer toBankTransfer() {
		at.ac.tuwien.infosys.aic11.services.BankTransfer bt = new at.ac.tuwien.infosys.aic11.services.BankTransfer();
		bt.setBankName( this.bankname );
		bt.setBic( this.bic );
		bt.setIban( this.iban );
		return bt;
	}

	public void fromRegistryService(
			at.ac.tuwien.infosys.aic11.services.DisbursementPreference dp) {
		if (dp instanceof at.ac.tuwien.infosys.aic11.services.BankTransfer) {
			at.ac.tuwien.infosys.aic11.services.BankTransfer bt = (at.ac.tuwien.infosys.aic11.services.BankTransfer) dp;
			this.bankname = bt.getBankName();
			this.bic = bt.getBic();
			this.iban = bt.getIban();
		}
	}

	public at.ac.tuwien.infosys.aic11.services.DisbursementPreference toRegistryService() {
		return toBankTransfer();
	}
}
