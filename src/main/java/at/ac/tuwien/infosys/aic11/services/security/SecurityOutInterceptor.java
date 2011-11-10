package at.ac.tuwien.infosys.aic11.services.security;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

public class SecurityOutInterceptor extends WSS4JOutInterceptor {

	public SecurityOutInterceptor() {
		super();
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("action", "UsernameToken Timestamp");

		props.put("passwordType", "PasswordText");
		props.put("user", "roman");
		props.put("passwordCallbackClass",
				"at.ac.tuwien.infosys.aic11.services.security.ServerPasswordCallback");
		this.setProperties(props);
	}
}
