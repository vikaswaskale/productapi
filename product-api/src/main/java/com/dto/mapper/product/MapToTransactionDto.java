package com.dto.mapper.product;

import java.text.SimpleDateFormat;

import com.dto.product.TransactionDetails;
import com.entity.product.Transaction;
/***
 * 
 * @author niku sharma
 * @implNote - Map business object to DTO - a non JPA session POJO
 *
 */
public class MapToTransactionDto {

	public static TransactionDetails mapToDto(Transaction transaction) {
		
		TransactionDetails dto = new TransactionDetails();

		dto.setAmount(transaction.getAmount());
		dto.setDebitCredit(transaction.getDebitCredit());
		dto.setDetails(transaction.getDetails());
		dto.setId(transaction.getId());
		dto.setProductId(transaction.getProductId());
		dto.setTransDescription(transaction.getTransDescription());

		// Convert Date
		String strDate = new SimpleDateFormat("dd-MMM-yyyy").format(transaction.getDateOn());
		dto.setDateToDisplay(strDate);
		dto.setDateOn(transaction.getDateOn());
		
		return dto;

	}
}
