package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    	itemList = entityManager.createQuery("select i from Item i").getResultList();
		
    	Inventory inventory = new Inventory();
		inventory.setItemList(itemList);
		return inventory;
	}

	@Override
	public boolean validateQuantity(Collection<Item> items) {
		
		return true;

	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		
		return true;
	}

}
