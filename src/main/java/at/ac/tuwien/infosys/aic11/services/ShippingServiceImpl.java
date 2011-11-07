package at.ac.tuwien.infosys.aic11.services;

import org.apache.cxf.interceptor.OutInterceptors;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.Customer;


@OutInterceptors(interceptors={})
public class ShippingServiceImpl {

	public void shipContract( CreditRequest c ) {
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
