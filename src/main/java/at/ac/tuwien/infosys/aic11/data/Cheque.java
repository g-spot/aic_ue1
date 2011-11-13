package at.ac.tuwien.infosys.aic11.data;

public class Cheque implements DisbursementPreference {

	private String name;
	
	public Cheque()	{}
	
	public Cheque( at.ac.tuwien.infosys.aic11.services.Cheque c ) {
		this.name = c.getName();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Checque: " + name;
	}
	
	public at.ac.tuwien.infosys.aic11.services.Cheque toCheque() {
		at.ac.tuwien.infosys.aic11.services.Cheque c = new at.ac.tuwien.infosys.aic11.services.Cheque();
		c.setName( this.name );
		return c;
	}
	
	public void fromRegistryService(
			at.ac.tuwien.infosys.aic11.services.DisbursementPreference dp) {
		if (dp instanceof at.ac.tuwien.infosys.aic11.services.Cheque) {
			at.ac.tuwien.infosys.aic11.services.Cheque c = (at.ac.tuwien.infosys.aic11.services.Cheque) dp;
			this.name = c.getName();
		}
	}

	public at.ac.tuwien.infosys.aic11.services.DisbursementPreference toRegistryService() {
		return toCheque();
	}
}
