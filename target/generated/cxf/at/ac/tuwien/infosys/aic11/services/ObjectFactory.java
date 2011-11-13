
package at.ac.tuwien.infosys.aic11.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.ac.tuwien.infosys.aic11.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Address_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "address");
    private final static QName _StartMoneyTransferProcess_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "start_money_transfer_process");
    private final static QName _InvalidParameter_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "invalid_parameter");
    private final static QName _DisbursementPreference_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "disbursement_preference");
    private final static QName _Money_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "money");
    private final static QName _StartMoneyTransferProcessResponse_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "start_money_transfer_processResponse");
    private final static QName _Cheque_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "cheque");
    private final static QName _Customer_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "customer");
    private final static QName _BankTransfer_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "bank_transfer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.ac.tuwien.infosys.aic11.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Cheque }
     * 
     */
    public Cheque createCheque() {
        return new Cheque();
    }

    /**
     * Create an instance of {@link StartMoneyTransferProcess }
     * 
     */
    public StartMoneyTransferProcess createStartMoneyTransferProcess() {
        return new StartMoneyTransferProcess();
    }

    /**
     * Create an instance of {@link BankTransfer }
     * 
     */
    public BankTransfer createBankTransfer() {
        return new BankTransfer();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link StartMoneyTransferProcessResponse }
     * 
     */
    public StartMoneyTransferProcessResponse createStartMoneyTransferProcessResponse() {
        return new StartMoneyTransferProcessResponse();
    }

    /**
     * Create an instance of {@link InvalidParameter }
     * 
     */
    public InvalidParameter createInvalidParameter() {
        return new InvalidParameter();
    }

    /**
     * Create an instance of {@link Money }
     * 
     */
    public Money createMoney() {
        return new Money();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartMoneyTransferProcess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "start_money_transfer_process")
    public JAXBElement<StartMoneyTransferProcess> createStartMoneyTransferProcess(StartMoneyTransferProcess value) {
        return new JAXBElement<StartMoneyTransferProcess>(_StartMoneyTransferProcess_QNAME, StartMoneyTransferProcess.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "invalid_parameter")
    public JAXBElement<InvalidParameter> createInvalidParameter(InvalidParameter value) {
        return new JAXBElement<InvalidParameter>(_InvalidParameter_QNAME, InvalidParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisbursementPreference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "disbursement_preference")
    public JAXBElement<DisbursementPreference> createDisbursementPreference(DisbursementPreference value) {
        return new JAXBElement<DisbursementPreference>(_DisbursementPreference_QNAME, DisbursementPreference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "money")
    public JAXBElement<Money> createMoney(Money value) {
        return new JAXBElement<Money>(_Money_QNAME, Money.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartMoneyTransferProcessResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "start_money_transfer_processResponse")
    public JAXBElement<StartMoneyTransferProcessResponse> createStartMoneyTransferProcessResponse(StartMoneyTransferProcessResponse value) {
        return new JAXBElement<StartMoneyTransferProcessResponse>(_StartMoneyTransferProcessResponse_QNAME, StartMoneyTransferProcessResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cheque }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "cheque")
    public JAXBElement<Cheque> createCheque(Cheque value) {
        return new JAXBElement<Cheque>(_Cheque_QNAME, Cheque.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "bank_transfer")
    public JAXBElement<BankTransfer> createBankTransfer(BankTransfer value) {
        return new JAXBElement<BankTransfer>(_BankTransfer_QNAME, BankTransfer.class, null, value);
    }

}
