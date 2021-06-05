package com.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.ProductServiceApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK, classes={ ProductServiceApplication.class })
public class ProductControllerTest {
  private MockMvc mockMvc;
  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setUp() {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }
  
  @Test
  public void when_fetchProducts_return_list() throws Exception {
    /* setup mock */
    mockMvc.perform(get("/products") 
             .accept(MediaType.APPLICATION_JSON))
             .andExpect(status().isOk())
             .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
             .andExpect(jsonPath("products[0].id").value("1"))
             .andExpect(jsonPath("products[0].productId").value("SA001"))
             .andExpect(jsonPath("products[0].productName").value("SAVING A/C"))
             .andExpect(jsonPath("products[0].sortCode").value("11-22-11"))
             .andExpect(jsonPath("products[0].accountNumber").value("012345671"))
             .andExpect(jsonPath("products[0].currentBalance").value(10000.59))
             .andExpect(jsonPath("products[0].availableBalance").value(10000.00));
  }
  
  @Test
  public void when_fetchTransactionsByProductId_filterBy_ALL_return_list() throws Exception {
    /* setup mock */
    mockMvc.perform(get("/transactions/SA001?filterBy=ALL") 
             .accept(MediaType.APPLICATION_JSON))
             .andExpect(status().isOk())
             .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
             .andExpect(jsonPath("transactions[0].id").value(1))
             .andExpect(jsonPath("transactions[0].dateOn").value("01-Jan-2019"))
             .andExpect(jsonPath("transactions[0].transactionList[0].id").value(1))
             .andExpect(jsonPath("transactions[0].transactionList[0].debitCredit").value("CR"))
             .andExpect(jsonPath("transactions[0].transactionList[0].productId").value("SA001"));
  }
  
  @Test
  public void when_fetchTransactionsByProductId_filterBy_DR_return_list() throws Exception {
    /* setup mock */
    mockMvc.perform(get("/transactions/SA001?filterBy=DR") 
             .accept(MediaType.APPLICATION_JSON))
             .andExpect(status().isOk())
             .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
             .andExpect(jsonPath("transactions[0].id").value(1))
             .andExpect(jsonPath("transactions[0].dateOn").value("01-Jan-2019"))
             .andExpect(jsonPath("transactions[0].transactionList[0].id").value(2))
             .andExpect(jsonPath("transactions[0].transactionList[0].debitCredit").value("DR"))
             .andExpect(jsonPath("transactions[0].transactionList[0].productId").value("SA001"));
  }
  
  @Test
  public void when_fetchTransactionsByProductId_filterBy_CR_return_list() throws Exception {
    /* setup mock */
    mockMvc.perform(get("/transactions/SA001?filterBy=CR") 
             .accept(MediaType.APPLICATION_JSON))
             .andExpect(status().isOk())
             .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
             .andExpect(jsonPath("transactions[0].id").value(1))
             .andExpect(jsonPath("transactions[0].dateOn").value("01-Jan-2019"))
             .andExpect(jsonPath("transactions[0].transactionList[0].id").value(1))
             .andExpect(jsonPath("transactions[0].transactionList[0].debitCredit").value("CR"))
             .andExpect(jsonPath("transactions[0].transactionList[0].productId").value("SA001"));
  }
  @Test
  public void when_fetchTransactionsByProductId_filterBy_TR_return_list() throws Exception {
    /* setup mock */
    mockMvc.perform(get("/transactions/SA001?filterBy=TR") 
             .accept(MediaType.APPLICATION_JSON))
             .andExpect(status().isUnprocessableEntity())
             .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
             .andExpect(jsonPath("errorCode").value("ERR_422"))
             .andExpect(jsonPath("titile").value("Error Happened"))
             .andExpect(jsonPath("message").value("Product Not Available !!!"));
  }
  @Test
  public void when_fetchTransactionsByProductId_filterBy_NULL_return_list() throws Exception {
    /* setup mock */
    mockMvc.perform(get("/transactions/SA001?filterBy=") 
             .accept(MediaType.APPLICATION_JSON))
             .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
             .andExpect(jsonPath("errorCode").value("ERR_422"))
             .andExpect(jsonPath("titile").value("Error Happened"))
             .andExpect(jsonPath("message").value("Transactions filter Not Provided !!!"));
  }
}