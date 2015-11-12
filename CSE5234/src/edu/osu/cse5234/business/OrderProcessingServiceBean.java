package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
public class OrderProcessingServiceBean {
	
	@PersistenceContext(unitName = "CSE5234")
	private EntityManager entityManager;
	
	@WebServiceRef(wsdlLocation ="http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
	private PaymentProcessorService service;

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
    	
    	return String.valueOf((int)(10000* Math.random()));
    }
    
  //Object#3&#4 (4)
    public boolean validateItemAvailability(Order order) {
    	boolean result = ServiceLocator.getInventoryService().validateQuantity(order.getLineItems());
    	return result;
    }
    
    
}
