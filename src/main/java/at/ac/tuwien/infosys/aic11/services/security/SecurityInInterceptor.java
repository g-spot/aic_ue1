package at.ac.tuwien.infosys.aic11.services.security;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;

public class SecurityInInterceptor extends WSS4JInInterceptor{

	public SecurityInInterceptor() {
		super();
		Map<String, Object> props = new HashMap<String, Object>();
        props.put("action", "UsernameToken Timestamp");
        props.put("passwordType", "PasswordDigest");
		props.put("passwordCallbackClass",
				"at.ac.tuwien.infosys.aic11.services.security.ServerPasswordCallback");
		this.setProperties( props );
	}
}
