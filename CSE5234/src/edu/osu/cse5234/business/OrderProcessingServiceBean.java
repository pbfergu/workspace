package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    /**
     * Default constructor. 
     */
	///test
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	//ServiceLocator.getInventoryService().updateInventory(order.getLineItems());
    	
    	entityManager.persist(order);
    	//entityManager.flush();
    	
    	return String.valueOf((int)(10000* Math.random()));
    }
    
  //Object#3&#4 (4)
    public boolean validateItemAvailability(Order order) {
    	boolean result = ServiceLocator.getInventoryService().validateQuantity(order.getLineItems());
    	return result;
    }
}
