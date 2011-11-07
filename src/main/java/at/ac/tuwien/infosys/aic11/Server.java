package at.ac.tuwien.infosys.aic11;

import javax.xml.ws.Endpoint;

import at.ac.tuwien.infosys.aic11.services.CustomerRelationsManagementServiceImpl;

public class Server {
	
	protected Server() throws Exception {
		System.out.println("START DA FUCKIN CR MANAGEMENT SERVICE...");
		CustomerRelationsManagementServiceImpl crManagerImpl = new CustomerRelationsManagementServiceImpl();
		String address = "http://localhost:9000/CRService";
		Endpoint.publish(address, crManagerImpl);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new Server();
		System.out.println("Server ready...");
		
		Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
	}

}
