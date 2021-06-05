package com.dto.product;

import java.util.ArrayList;
import java.util.List;

public class TransactionsDto {
	private List<TransactionDto> transactions = new ArrayList<TransactionDto>();

	public TransactionsDto(List<TransactionDto> transactions) {
		this.transactions = transactions;
	}

	public List<TransactionDto> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDto> transactions) {
		this.transactions = transactions;
	}

}
