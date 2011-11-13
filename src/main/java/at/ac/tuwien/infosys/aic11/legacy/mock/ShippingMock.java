package at.ac.tuwien.infosys.aic11.legacy.mock;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.legacy.ShippingInterface;

public class ShippingMock implements ShippingInterface {

	public void shipRequest( CreditRequest cr ) {
		try {
			Thread.sleep( 100000 );
		} catch (InterruptedException e) {
			
		}
	}
}
