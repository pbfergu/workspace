package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.business.view.LineItem;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	
	@PersistenceContext private EntityManager entityManager;

	//private Inventory inventory = new Inventory();
	
    @SuppressWarnings("unchecked")
	public InventoryServiceBean() {
    }

	@Override
	public Inventory getAvailableInventory() {
		List<Item> itemList = new ArrayList<Item>();
		/*Item item = new Item();
		item.setId(1);
		item.setName("name");
		item.setQuantity(1);
		item.setUnitPrice(new BigDecimal("1.00"));
		entityManager.persist(item);*/
    	itemList = entityManager.createQuery("select i from Item i").getResultList();
		
    	Inventory inventory = new Inventory();
		inventory.setItemList(itemList);
		return inventory;
	}

	@Override
	public boolean validateQuantity(Collection<LineItem> items) {
		
		return true;

	}

	@Override
	public boolean updateInventory(Collection<LineItem> items) {
		
		return true;
	}

}
