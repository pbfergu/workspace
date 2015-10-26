package edu.osu.cse5234.business;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

	private Inventory inventory = new Inventory();
	
    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
    	
    	
    	
    	List<Item> itemList = new ArrayList<Item>();
		
		Item item1 = new Item();
		item1.setName("Ray Ban");
		item1.setQuantity("10");
		itemList.add(item1);
		
		Item item2 = new Item();
		item2.setName("Levis");
		item2.setQuantity("20");
		itemList.add(item2);
		
		Item item3 = new Item();
		item3.setName("Gucci");
		item3.setQuantity("30");
		itemList.add(item3);
		
		Item item4 = new Item();
		item4.setName("Prada");
		item4.setQuantity("40");
		itemList.add(item4);
		
		Item item5 = new Item();
		item5.setName("Oakley");
		item5.setQuantity("50");
		itemList.add(item5);
		
		inventory.setItemList(itemList);
    }

	@Override
	public Inventory getAvailableInventory() {
		return inventory;
	}

	@Override
	public boolean validateQuantity(Collection<Item> items) {
		// TODO Auto-generated method stub
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item item = it.next();
			if(item.getName().equals("Ray Ban")){
				Item item_0 = (Item)inventory.getItemList().get(0);
				if(Integer.valueOf(item_0.getQuantity()) < Integer.valueOf(item.getQuantity()))
					return false;
			}
			else if(item.getName().equals("Ray Ban")){
				Item item_1 = (Item)inventory.getItemList().get(1);
				if(Integer.valueOf(item_1.getQuantity()) < Integer.valueOf(item.getQuantity()))
					return false;
			}
			else if(item.getName().equals("Ray Ban")){
				Item item_2 = (Item)inventory.getItemList().get(2);
				if(Integer.valueOf(item_2.getQuantity()) < Integer.valueOf(item.getQuantity()))
					return false;
			}
			else if(item.getName().equals("Ray Ban")){
				Item item_3 = (Item)inventory.getItemList().get(3);
				if(Integer.valueOf(item_3.getQuantity()) < Integer.valueOf(item.getQuantity()))
					return false;
			}
			else if(item.getName().equals("Ray Ban")){
				Item item_4 = (Item)inventory.getItemList().get(4);
				if(Integer.valueOf(item_4.getQuantity()) < Integer.valueOf(item.getQuantity()))
					return false;
			}
		}
		return true;

	}

	@Override
	public boolean updateInventory(Collection<Item> items) {
		// TODO Auto-generated method stub
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item item = it.next();
			if(item.getName().equals("Ray Ban")){
				Item item_0 = (Item)inventory.getItemList().get(0);
				item_0.setQuantity(String.valueOf(Integer.valueOf(item_0.getQuantity()) - Integer.valueOf(item.getQuantity())));
				inventory.getItemList().set(0, item_0);
			}
			else if(item.getName().equals("Levis")){
				Item item_1 = (Item)inventory.getItemList().get(1);
				item_1.setQuantity(String.valueOf(Integer.valueOf(item_1.getQuantity()) - Integer.valueOf(item.getQuantity())));
				inventory.getItemList().set(1, item_1);
			}
			else if(item.getName().equals("Gucci")){
				Item item_2 = (Item)inventory.getItemList().get(2);
				item_2.setQuantity(String.valueOf(Integer.valueOf(item_2.getQuantity()) - Integer.valueOf(item.getQuantity())));
				inventory.getItemList().set(2, item_2);
			}
			else if(item.getName().equals("Prada")){
				Item item_3 = (Item)inventory.getItemList().get(3);
				item_3.setQuantity(String.valueOf(Integer.valueOf(item_3.getQuantity()) - Integer.valueOf(item.getQuantity())));
				inventory.getItemList().set(3, item_3);
			}
			else if(item.getName().equals("Oakley")){
				Item item_4 = (Item)inventory.getItemList().get(4);
				item_4.setQuantity(String.valueOf(Integer.valueOf(item_4.getQuantity()) - Integer.valueOf(item.getQuantity())));
				inventory.getItemList().set(4, item_4);
			}
		}
		return true;
	}

}
