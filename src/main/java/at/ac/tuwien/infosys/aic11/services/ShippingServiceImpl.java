package at.ac.tuwien.infosys.aic11.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;

import at.ac.tuwien.infosys.aic11.data.CreditRequest;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestDTO;
import at.ac.tuwien.infosys.aic11.data.dtos.CreditRequestMarshaller;
import at.ac.tuwien.infosys.aic11.legacy.ShippingInterface;
import at.ac.tuwien.infosys.aic11.legacy.mock.ShippingMock;

public class ShippingServiceImpl implements ShippingService{

	private boolean disbursed = false, shipped = false;
	
	public void acceptOffer( CreditRequestDTO c ) {
		CreditRequest cr = CreditRequestMarshaller.unmarshall( c );
		Executors.defaultThreadFactory().newThread( new Disburser( cr ) ).start();
		Executors.defaultThreadFactory().newThread( new Shipper( cr ) ).start();
		
	}
	
	private synchronized void offerDone() {
		if( !disbursed || !shipped )
			return;
			
		//Offer accepted
	}
	
	private class Disburser extends Thread {
		
		private CreditRequest cr;
		
		public Disburser( CreditRequest cr ) {
			this.cr = cr;
		}
		
		@Override
		public void run() {
			super.run();
			URL registry_wsdl = Disburser.class.getClassLoader().getResource( "wsdl/registry_service.wsdl" );
			// if we dont't do this, it takes the absolute path from the generated files
			IRegistryService rs = new RegistryService( registry_wsdl ).getRegistryService();
			WsdlEndpoint wsep;
			try {
				wsep = rs.query( cr.getCustomer().getDisbursementpreference().toRegistryService() );
			} catch (InvalidParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			
			IDisbursementService ds;
			try {
				ds = new DisbursementService( new URL( wsep.getLocation() ) ).getDisbursementService();
				ds.startMoneyTransferProcess( cr.getCustomer().getDisbursementpreference().toRegistryService(), cr.getMoney().toMoney(), cr.getCustomer().toCustomer() );
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return;
			} catch (InvalidParameterException e) {
				e.printStackTrace();
				return;
			}
			disbursed = true;
			offerDone();
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
			shipped = true;
			offerDone();
		}
	}
}
