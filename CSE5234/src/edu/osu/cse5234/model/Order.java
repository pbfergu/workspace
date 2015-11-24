package edu.osu.cse5234.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.osu.cse5234.business.view.LineItem;

@Entity
@Table(name="CUSTOMER_ORDER")
public class Order {
	
	private int id;
	private String customerName;
	//private String emailAddress;
	private List<LineItem> lineItems;
	private PaymentInfo paymentInfo;
	private ShippingInfo shippingInfo;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="CUSTOMER_NAME")
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/*
	@Column(name="CUSTOMER_EMAIL")
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}*/
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_ORDER_ID_FK")
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="PAYMENT_ID", referencedColumnName="CUSTOMER_ORDER_ID_FK2")
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SHIPPING_ID", referencedColumnName="CUSTOMER_ORDER_ID_FK3")
	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
		
	
}
