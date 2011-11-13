package at.ac.tuwien.infosys.aic11.services.security.visualisation;

import java.util.logging.Logger;

import org.apache.cxf.interceptor.transform.TransformInInterceptor;
import org.apache.cxf.message.Message;

public class ShowDecryptedMessage extends TransformInInterceptor {

	@Override
	public void handleMessage(Message message) {
		Logger.getLogger("at.ac.tuwien.infosys.aic11.Server").info( "Decrypted: \n" + message.toString() );
	}
}
