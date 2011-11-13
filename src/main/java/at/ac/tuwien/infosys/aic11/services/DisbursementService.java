package at.ac.tuwien.infosys.aic11.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.3
 * 2011-11-13T19:39:12.271+01:00
 * Generated source version: 2.4.3
 * 
 */
@WebServiceClient(name = "Disbursement_Service", 
                  wsdlLocation = "http://vc.infosys.tuwien.ac.at:8090/banking?wsdl",
                  targetNamespace = "http://services.aic11.infosys.tuwien.ac.at/") 
public class DisbursementService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://services.aic11.infosys.tuwien.ac.at/", "Disbursement_Service");
    public final static QName DisbursementService = new QName("http://services.aic11.infosys.tuwien.ac.at/", "Disbursement_Service");
    static {
        URL url = null;
        try {
            url = new URL("http://vc.infosys.tuwien.ac.at:8090/banking?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(DisbursementService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://vc.infosys.tuwien.ac.at:8090/banking?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DisbursementService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DisbursementService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DisbursementService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns IDisbursementService
     */
    @WebEndpoint(name = "Disbursement_Service")
    public IDisbursementService getDisbursementService() {
        return super.getPort(DisbursementService, IDisbursementService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IDisbursementService
     */
    @WebEndpoint(name = "Disbursement_Service")
    public IDisbursementService getDisbursementService(WebServiceFeature... features) {
        return super.getPort(DisbursementService, IDisbursementService.class, features);
    }

}
