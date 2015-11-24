package edu.osu.cse5234.business;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;

import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
@Resource(name="jms/emailQCF", lookup="jms/emailQCF", type=ConnectionFactory.class) 

public class OrderProcessingServiceBean {
	
	@PersistenceContext(unitName = "CSE5234")
	private EntityManager entityManager;
	
	@WebServiceRef(wsdlLocation ="http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
	private PaymentProcessorService service;

	@Inject
	@JMSConnectionFactory("java:comp/env/jms/emailQCF")
	private JMSContext jmsContext;

	@Resource(lookup="jms/emailQ")
	private Queue queue;

    /**
     * Default constructor. 
     */
	///test
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	//ServiceLocator.getInventoryService().updateInventory(order.getLineItems());
    	
    	
    	
    	CreditCardPayment creditCardPayment = new CreditCardPayment();
    	creditCardPayment.setCardHolderName(order.getPaymentInfo().getCardHolderName());
    	creditCardPayment.setCreditCardNumber(order.getPaymentInfo().getCreditCardNumber());
    	creditCardPayment.setCvvCode(order.getPaymentInfo().getCvvCode());
    	creditCardPayment.setExpDate(order.getPaymentInfo().getExpDate());
    	
    	String result = service.getPaymentProcessorPort().processPayment(creditCardPayment);
    	
    	if(Integer.parseInt(result) < 0) {
    		return "failed";
        	
    	}
    	order.getPaymentInfo().setConfirmationNumber(result);
    	entityManager.persist(order);
    	entityManager.flush();
    	
    	notifyUser(order.getPaymentInfo().getEmailAddress());
    	
    	return String.valueOf((int)(10000* Math.random()));
    }
    
    private void notifyUser(String customerEmail) {

    	String message = customerEmail + ":" +
    	       "Your order was successfully submitted. " + 
    	     	"You will hear from us when items are shipped. " + 
    	      	new Date();

    	System.out.println("Sending message: " + message);
    	jmsContext.createProducer().send(queue, message);
    	System.out.println("Message Sent!");
    	}

    
  //Object#3&#4 (4)
    public boolean validateItemAvailability(Order order) {
    	boolean result = ServiceLocator.getInventoryService().validateQuantity(order.getLineItems());
    	return result;
    }
    
    
}
