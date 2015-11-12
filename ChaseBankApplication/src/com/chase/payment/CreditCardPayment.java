package com.chase.payment;

import java.io.Serializable;

public class CreditCardPayment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1343592722420701635L;
	
	private String creditCardNumber;
	private String expDate;
	private String cvvCode;
	private String cardHolderName;
	
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	public String getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
	
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

}
