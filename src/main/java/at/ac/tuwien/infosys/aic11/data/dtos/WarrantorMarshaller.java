package at.ac.tuwien.infosys.aic11.data.dtos;

import at.ac.tuwien.infosys.aic11.data.Warrantor;

public class WarrantorMarshaller {

	public static WarrantorDTO marshall( Warrantor w ) {
		return new WarrantorDTO( w.getCustomerid() );
	}
	
	public static Warrantor unmarshall( WarrantorDTO wdto ) {
		//TODO
		return null;
		
	}
}
