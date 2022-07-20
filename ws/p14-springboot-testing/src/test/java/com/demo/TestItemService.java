package com.demo;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.exceptions.OrderException;
import com.demo.models.Order;
import com.demo.repositories.ItemRepository;
import com.demo.services.ItemService;

@SpringBootTest
public class TestItemService {

	@Autowired
	private ItemService service;
	
	@MockBean
	private ItemRepository repo;
	
	@Test
	public void serviceShouldPlaceOrder() throws SQLException, OrderException {
		Order order = new Order("Mobile", 19000);
		
		/*
		if we want to use "repo.saveOrderInDb(order)"
		mockito should replace it with
		new Order(123, "Shirt", 500);
		*/
		
		Mockito.when(repo.saveOrderInDb(order)).thenReturn(new Order(123, "Shirt", 500));
		
		boolean isOrderPlaced = service.placeOrder(order);
		Assertions.assertTrue(isOrderPlaced);
	}

	@Test
	public void serviceShouldNotPlaceOrder() throws SQLException, OrderException {
		Order order = new Order("Mobile", 0);
		Mockito.when(repo.saveOrderInDb(order)).thenReturn(new Order(0, "Shirt", 500));
		
		boolean isOrderPlaced = service.placeOrder(order);
		Assertions.assertFalse(isOrderPlaced);
		
	}
	
	@Test
	public void serviceShouldNotPlaceOrderWithNull() throws SQLException, OrderException {
		Order order = null;
		Mockito.when(repo.saveOrderInDb(order)).thenReturn(null);
		
		boolean isOrderPlaced = service.placeOrder(order);
		Assertions.assertFalse(isOrderPlaced);
		
	}
	
	@Test
	public void serviceShouldNotPlaceOrderWhenDbError() throws SQLException, OrderException {
		Order order = null;
		Mockito.when(repo.saveOrderInDb(order)).thenThrow(SQLException.class);

		Assertions.assertThrows(OrderException.class, ()->{			
			service.placeOrder(order);
		});
		
	}
	
	
}
