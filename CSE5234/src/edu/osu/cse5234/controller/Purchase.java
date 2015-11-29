package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.business.view.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping("/purchase")
public class Purchase {
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Inventory inventory = ServiceLocator.getInventoryService().getAvailableInventory();

		request.setAttribute("inventory", inventory);
		return "OrderEntryForm";
	}

	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("inventory") Inventory inventory, HttpServletRequest request){
		List<LineItem> lineItems = new ArrayList<LineItem>();
		for(Item item : inventory.getItemList()) {
			LineItem lineItem = new LineItem();
			lineItem.setItemId(item.getId());
			lineItem.setItemName(item.getName());
			System.out.println(item.getName() + " - " + lineItem.getItemName());
			lineItem.setQuantity(item.getQuantity());
			lineItems.add(lineItem);
		}
		Order order = new Order();
		order.setLineItems(lineItems);
		
		//Object#3&#4 (5)
		Boolean isvalid = ServiceLocator.getOrderProcessingService().validateItemAvailability(order);
		if(!isvalid){
			request.setAttribute("invalidMessage", "Please resubmit item quantities");
			//request.getRequestDispatcher("OrderEntryForm").forward(request,response);
			return "OrderEntryForm";
		}
		
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());	
		return "PaymentEntryForm";
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submmitPayment(@ModelAttribute("payment") PaymentInfo paymentInfo, HttpServletRequest request) {
		request.getSession().setAttribute("payment", paymentInfo);	
		Order order = (Order) request.getSession().getAttribute("order");
		order.setPaymentInfo(paymentInfo);
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shippingInfo", new ShippingInfo());	
		return "ShippingEntryForm";
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		Order order = (Order) request.getSession().getAttribute("order");
		order.setShippingInfo(shippingInfo);
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrder(HttpServletRequest request, HttpServletResponse response) {
		Order order = (Order) request.getSession().getAttribute("order");
		for(LineItem lineItem : order.getLineItems()) {
			System.out.println(lineItem.getItemName());
		}
		return "ViewOrder";
	}

	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request) {
		return "redirect:/purchase/Confirmation";
	}
	
	@RequestMapping(path = "/Confirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("confirmationCode", ServiceLocator.getOrderProcessingService().processOrder((Order)request.getSession().getAttribute("order")));
		//request.setAttribute("confirmationCode", "1");
		return "Confirmation";
	}
}
