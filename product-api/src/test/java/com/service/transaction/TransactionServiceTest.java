package com.service.transaction;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.dto.product.TransactionDetails;
import com.dto.product.TransactionsDto;
import com.entity.product.Transaction;
import com.error.controller.product.ApplicationError;
import com.repository.product.TransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {
	@Mock
	private TransactionRepository transactionRepository;

	@InjectMocks
	private TransactionServiceImpl transactionService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void when_fetch_all_Transactions_returnList() throws Exception {
		// given
		Transaction transaction1 = new Transaction();
		transaction1.setId(Long.valueOf(1));
		transaction1.setProductId("SA001");
		transaction1.setDateOn(Date.valueOf("2019-01-01"));
		transaction1.setDebitCredit("DR");
		transaction1.setTransDescription("MORRISON Shopping");
		transaction1.setDetails("Trans at MORRISON Livingston");
		transaction1.setAmount(new BigDecimal(10020.20));

		Transaction transaction2 = new Transaction();
		transaction2.setId(Long.valueOf(2));
		transaction2.setProductId("SA001");
		transaction2.setDateOn(Date.valueOf("2019-01-01"));
		transaction2.setDebitCredit("CR");
		transaction2.setTransDescription("ASDA Shopping");
		transaction2.setDetails("Trans at ASDA Livingston");
		transaction2.setAmount(new BigDecimal(100.20));

		List<Transaction> expectedTransactions = Arrays.asList(transaction1, transaction2);

		when(transactionRepository.findTransactionByProductId("SA001", Arrays.asList("CR", "DR")))
				.thenReturn(expectedTransactions);

		TransactionsDto returnValue = transactionService.fetchTransactionByProductId("SA001",
				Arrays.asList("ALL"));

		assertEquals(1, returnValue.getTransactions().size());
		assertEquals(1, returnValue.getTransactions().get(0).getId());
		assertEquals("SA001", returnValue.getTransactions().get(0).getTransactionList().get(0).getProductId());

	}

	@Test
	public void when_fetch_DR_Transactions_returnList() throws Exception {
		// given
		Transaction transaction1 = new Transaction();
		transaction1.setId(Long.valueOf(1));
		transaction1.setProductId("SA001");
		transaction1.setDateOn(Date.valueOf("2019-01-01"));
		transaction1.setDebitCredit("DR");
		transaction1.setTransDescription("MORRISON Shopping");
		transaction1.setDetails("Trans at MORRISON Livingston");
		transaction1.setAmount(new BigDecimal(10020.20));

		List<Transaction> expectedTransactions = Arrays.asList(transaction1);

		when(transactionRepository.findTransactionByProductId("SA001", Arrays.asList("DR")))
				.thenReturn(expectedTransactions);

		TransactionsDto returnValue = transactionService.fetchTransactionByProductId("SA001",
				Arrays.asList("DR"));

		assertEquals(1, returnValue.getTransactions().size());
		assertEquals(1, returnValue.getTransactions().get(0).getId());
		assertEquals("SA001", returnValue.getTransactions().get(0).getTransactionList().get(0).getProductId());

	}

	@Test
	public void when_fetch_CR_Transactions_returnList() throws Exception {
		// given

		Transaction transaction2 = new Transaction();
		transaction2.setId(Long.valueOf(2));
		transaction2.setProductId("SA001");
		transaction2.setDateOn(Date.valueOf("2019-01-01"));
		transaction2.setDebitCredit("CR");
		transaction2.setTransDescription("ASDA Shopping");
		transaction2.setDetails("Trans at ASDA Livingston");
		transaction2.setAmount(new BigDecimal(100.20));

		List<Transaction> expectedTransactions = Arrays.asList(transaction2);

		when(transactionRepository.findTransactionByProductId("SA001", Arrays.asList("CR")))
				.thenReturn(expectedTransactions);

		TransactionsDto returnValue = transactionService.fetchTransactionByProductId("SA001",
				Arrays.asList("CR"));

		assertEquals(1, returnValue.getTransactions().size());
		assertEquals(2, returnValue.getTransactions().get(0).getTransactionList().get(0).getId().intValue());
		assertEquals("SA001", returnValue.getTransactions().get(0).getTransactionList().get(0).getProductId());

	}
	@Test(expected = ApplicationError.class)
	public void when_error_happen_Transactions_returnList() throws Exception {
		// given

		Transaction transaction2 = new Transaction();
		transaction2.setId(Long.valueOf(2));
		transaction2.setProductId("SA001");
		transaction2.setDateOn(Date.valueOf("2019-01-01"));
		transaction2.setDebitCredit("CR");
		transaction2.setTransDescription("ASDA Shopping");
		transaction2.setDetails("Trans at ASDA Livingston");
		transaction2.setAmount(new BigDecimal(100.20));

		List<Transaction> expectedTransactions = Arrays.asList(transaction2);

		when(transactionRepository.findTransactionByProductId("SA001", Arrays.asList("CR1")))
				.thenReturn(expectedTransactions);
		
		/* Check if we get NoProductFoundException */

		transactionService.fetchTransactionByProductId("SA001",
				Arrays.asList("CR"));

	}
}
