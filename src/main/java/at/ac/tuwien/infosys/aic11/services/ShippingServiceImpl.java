package at.ac.tuwien.infosys.aic11.services;

import java.util.concurrent.Executors;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Customer;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestDTO;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestMarshaller;

public class ShippingServiceImpl implements ShippingService{

	public void acceptOffer( CreditRequestDTO c ) {
		CreditRequest cr = CreditRequestMarshaller.unmarshall( c );
		Executors.defaultThreadFactory().newThread( new Disburser( cr.getCustomer() ) ).start();
		Executors.defaultThreadFactory().newThread( new Shipper( cr ) ).start();
	}
	
	private class Disburser extends Thread {
		
		public Disburser( Customer c ) {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		}
	}
	
	private class Shipper extends Thread {
		
		public Shipper( CreditRequest cr ) {
			
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			
		}
	}
}
