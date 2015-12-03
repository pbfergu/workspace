package edu.osu.cse5234.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.osu.cse5234.business.view.LineItem;

@Entity
@Table(name="CUSTOMER_ORDER")
public class Order {
	
	private int id;
	private String customerName;
	private String status;
	//private String emailAddress;
	private List<LineItem> lineItems;
	private PaymentInfo paymentInfo;
	private ShippingInfo shippingInfo;
	
	@PrePersist
	public void prePersistCallBack(){
		if(shippingInfo != null) {
			shippingInfo.setOrderId(this.id);
		}
		if(paymentInfo != null) {
			paymentInfo.setOrderId(this.id);
		}
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_gen_sequence")
	@SequenceGenerator(name="seq_gen_sequence", sequenceName="SEQ_GEN_SEQUENCE", allocationSize=500)
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
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	@JoinColumn(name="PAYMENT_ID",insertable=false, updatable=false)
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SHIPPING_ID",insertable=false, updatable=false)
	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
		
	
}
