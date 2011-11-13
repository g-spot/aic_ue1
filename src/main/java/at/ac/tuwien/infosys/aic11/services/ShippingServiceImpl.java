package at.ac.tuwien.infosys.aic11.services;

import java.util.concurrent.Executors;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestDTO;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestMarshaller;
import at.ac.tuwien.infosys.aic11.legacy.ShippingInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.ShippingMock;

public class ShippingServiceImpl implements ShippingService{

	public void acceptOffer( CreditRequestDTO c ) {
		CreditRequest cr = CreditRequestMarshaller.unmarshall( c );
		Executors.defaultThreadFactory().newThread( new Disburser( cr.getCustomer() ) ).start();
		Executors.defaultThreadFactory().newThread( new Shipper( cr ) ).start();
	}
	
	private class Disburser extends Thread {
		
		private Customer c;
		
		public Disburser( Customer c ) {
			this.c = c;
		}
		
		@Override
		public void run() {
			super.run();
			//TODO Shorty: WS Call
		}
	}
	
	private class Shipper extends Thread {
		
		private CreditRequest cr;
		private ShippingInterface si = new ShippingMock();
		
		public Shipper( CreditRequest cr ) {
			this.cr = cr;
		}
		
		@Override
		public void run() {
			super.run();
			si.shipRequest( this.cr );
		}
	}
}
