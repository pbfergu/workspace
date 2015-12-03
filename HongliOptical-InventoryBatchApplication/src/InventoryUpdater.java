import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InventoryUpdater {

	public static void main(String[] args) {

		System.out.println("Starting Inventory Update ...");
		try {
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn);
			udpateInventory(orderedItems, conn);
			udpateOrderStatus(newOrderIds, conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:/Users/Zeller/HongliOptical", "sa", "");
		return conn;
	}

	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rset = conn.createStatement().executeQuery(
                     "select ID from CUSTOMER_ORDER where STATUS = 'New'");
		while (rset.next()) {
			orderIds.add(new Integer(rset.getInt("ID")));
		}
		return orderIds;
	}

	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds,
                Connection conn)  throws SQLException {
		// TODO Auto-generated method stub
		// This method returns a map of two integers. The first Integer is item ID, and 
        // the second is cumulative requested quantity across all new orders
		Map<Integer,Integer> orderedLineItems = new HashMap<Integer,Integer>();
		Iterator iterator = newOrderIds.iterator();
		while(iterator.hasNext()){
			int orderID = (int) iterator.next();
			ResultSet rset = conn.createStatement().executeQuery(
                "select ITEM_ID, QUANTITY from CUSTOMER_ORDER_LINE_ITEM where CUSTOMER_ORDER_ID_FK = '"+ orderID +"'");
			while(rset.next()){
				int itemID = new Integer(rset.getInt("ITEM_ID"));
				int quantity = new Integer(rset.getInt("QUANTITY"));
				if(orderedLineItems.containsKey(itemID))
					orderedLineItems.put(itemID,orderedLineItems.get(itemID)+quantity);
				else
					orderedLineItems.put(itemID,quantity);
			}
		}
		return orderedLineItems;
	}

	private static void udpateInventory(Map<Integer, Integer> orderedItems, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		Iterator iterator = orderedItems.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry entry = (Map.Entry)iterator.next();
			int itemID = (int) entry.getKey();
			int quantity = (int) entry.getValue();
			conn.createStatement().executeQuery("update ITEM set AVAILABLE_QUANTITY = AVAILABLE_QUANTITY - "+quantity+"where ID = "+itemID );
			
		}

	}

	private static void udpateOrderStatus(Collection<Integer> newOrderIds, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		Iterator iterator = newOrderIds.iterator();
		while(iterator.hasNext()){
			int orderID = (int) iterator.next();
			conn.createStatement().executeQuery("update CUSTOMER_ORDER set STATUS = 'Old' where ID = "+ orderID );
		}
	}


}
