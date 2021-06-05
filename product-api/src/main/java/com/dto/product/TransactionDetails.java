package com.dto.product;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDetails {
	private Long id;
	private String productId;
	private Date dateOn;
	private String debitCredit;
	private String transDescription;
	private String details;
	private BigDecimal amount;
	private String dateToDisplay;
	
	
	public String getDateToDisplay() {
		return dateToDisplay;
	}
	public void setDateToDisplay(String dateToDisplay) {
		this.dateToDisplay = dateToDisplay;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Date getDateOn() {
		return dateOn;
	}
	public void setDateOn(Date dateOn) {
		this.dateOn = dateOn;
	}
	public String getDebitCredit() {
		return debitCredit;
	}
	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}
	public String getTransDescription() {
		return transDescription;
	}
	public void setTransDescription(String transDescription) {
		this.transDescription = transDescription;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
