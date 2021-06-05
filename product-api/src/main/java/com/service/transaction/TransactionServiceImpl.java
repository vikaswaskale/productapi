package com.service.transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.mapper.product.MapToTransactionDto;
import com.dto.product.TransactionDetails;
import com.dto.product.TransactionDto;
import com.dto.product.TransactionsDto;
import com.entity.product.Transaction;
import com.error.controller.product.ErrorMessage;
import com.error.controller.product.ApplicationError;
import com.repository.product.TransactionRepository;

@Service(value = "transactionService")
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public TransactionsDto fetchTransactionByProductId(String productId, List<String> filterBy) throws Exception {
		TransactionsDto returnDto = null;
		List<TransactionDto> transactionsDtos = new ArrayList<TransactionDto>();
		/**
		 * Check if filter selected for option - ALL
		 */
		if (filterBy==null || filterBy.size()<=0 ) {
			ErrorMessage errorMessage = new ErrorMessage("ERR_422", "Error Happened", "Transactions filter Not Provided !!!");
			throw new ApplicationError(errorMessage);

		}
		
		/**
		 * Check if filter selected for option - ALL
		 */
		if (filterBy!=null && filterBy.size()>0 && filterBy.get(0).equalsIgnoreCase("ALL")) {
			List<String> tempList = Arrays.asList("CR", "DR");
			filterBy = tempList;

		}

		List<Transaction> transactions = transactionRepository.findTransactionByProductId(productId, filterBy);

		List<TransactionDetails> transactionsDto = new ArrayList<TransactionDetails>();

		for (Transaction transaction : transactions) {
			transactionsDto.add(MapToTransactionDto.mapToDto(transaction));
		}

		/** Sort list by dates */
		Map<Date, List<TransactionDetails>> sortByDate = transactionsDto.stream()
				.collect(Collectors.groupingBy(TransactionDetails::getDateOn));

		/** Group by Date */
		Map<Date, List<TransactionDetails>> groupByDate = new TreeMap<Date, List<TransactionDetails>>(sortByDate);

		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

		for (Map.Entry<Date, List<TransactionDetails>> entry : groupByDate.entrySet()) {
			TransactionDto transactionDtoObj = new TransactionDto(transactionsDtos.size() + 1,
					df.format(entry.getKey()), entry.getValue());
			transactionsDtos.add(transactionDtoObj);
		}

		/**
		 * Handle Error if the product is not available for any reason
		 */

		if (transactionsDtos.isEmpty()) {
			ErrorMessage errorMessage = new ErrorMessage("ERR_422", "Error Happened", "Product Not Available !!!");
			throw new ApplicationError(errorMessage);
		}

		returnDto = new TransactionsDto(transactionsDtos);
		return returnDto;
	}

}
