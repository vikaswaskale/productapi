package com.dto.product;

import java.util.ArrayList;
import java.util.List;

public class TransactionDto {
	private int id;
	private String dateOn;
	private List<TransactionDetails> transactionList = new ArrayList<TransactionDetails>();
	
	public TransactionDto() {
		// TODO Auto-generated constructor stub
	}

	public TransactionDto(int id, String dateOn, List<TransactionDetails> transactionList) {
		this.dateOn = dateOn;
		this.id = id;
		this.transactionList = transactionList;
	}

	public String getDateOn() {
		return dateOn;
	}

	public void setDateOn(String dateOn) {
		this.dateOn = dateOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public List<TransactionDetails> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<TransactionDetails> transactionList) {
		this.transactionList = transactionList;
	}

}
