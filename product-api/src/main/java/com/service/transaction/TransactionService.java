package com.service.transaction;

import java.util.List;

import com.dto.product.TransactionsDto;
/***
 * 
 * @author niku sharma
 * @implNote - A Business service  to Transaction Service
 *
 */
public interface TransactionService {
	
	/***
	 * @return transactionDto, sorted by dates and grouped by date.
	 */
	
	public TransactionsDto  fetchTransactionByProductId(String productId, List<String> filterBy) throws Exception ;
}
