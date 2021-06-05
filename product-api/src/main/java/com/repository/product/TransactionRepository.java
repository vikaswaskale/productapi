package com.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.product.Transaction;

/***
 * 
 * @author niku sharma
 * @implNote - A DAO interface to Transaction and linked with JPA for Transaction Table
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query("SELECT t FROM Transaction t  where t.productId = :productId AND debitCredit IN (:filterBy)")
	public List<Transaction> findTransactionByProductId(@Param("productId") String productId,@Param("filterBy") List<String>  filterBy);

}
