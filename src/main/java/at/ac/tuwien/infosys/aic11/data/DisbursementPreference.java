package at.ac.tuwien.infosys.aic11.data;

public interface DisbursementPreference {
	//Nothing
	public void fromRegistryService( at.ac.tuwien.infosys.aic11.services.DisbursementPreference dp );
	public at.ac.tuwien.infosys.aic11.services.DisbursementPreference toRegistryService();
}
