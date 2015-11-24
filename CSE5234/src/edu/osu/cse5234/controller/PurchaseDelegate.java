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
import javax.jws.WebService;


@WebService (targetNamespace="http://controller.cse5234.osu.edu/", serviceName="PurchaseService", portName="PurchasePort")
public class PurchaseDelegate{

    edu.osu.cse5234.controller.Purchase _purchase = null;

    public String viewOrderEntryPage (HttpServletRequest request, HttpServletResponse response) throws Exception {
        return _purchase.viewOrderEntryPage(request,response);
    }

    public String submitItems (Inventory inventory, HttpServletRequest request) {
        return _purchase.submitItems(inventory,request);
    }

    public String viewPaymentEntryPage (HttpServletRequest request, HttpServletResponse response) {
        return _purchase.viewPaymentEntryPage(request,response);
    }

    public String submmitPayment (PaymentInfo paymentInfo, HttpServletRequest request) {
        return _purchase.submmitPayment(paymentInfo,request);
    }

    public String viewShippingEntryPage (HttpServletRequest request, HttpServletResponse response) {
        return _purchase.viewShippingEntryPage(request,response);
    }

    public String submitShipping (ShippingInfo shippingInfo, HttpServletRequest request) {
        return _purchase.submitShipping(shippingInfo,request);
    }

    public String viewOrder (HttpServletRequest request, HttpServletResponse response) {
        return _purchase.viewOrder(request,response);
    }

    public String confirmOrder (ShippingInfo shippingInfo, HttpServletRequest request) {
        return _purchase.confirmOrder(shippingInfo,request);
    }

    public String viewConfirmation (HttpServletRequest request, HttpServletResponse response) {
        return _purchase.viewConfirmation(request,response);
    }

    public PurchaseDelegate() {
        _purchase = new edu.osu.cse5234.controller.Purchase(); }

}