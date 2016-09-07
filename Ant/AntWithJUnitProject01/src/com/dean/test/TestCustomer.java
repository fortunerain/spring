package com.dean.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dean.code.Customer;

public class TestCustomer {

	@Test
	public void testCustomerId() {
		Customer cs = new Customer(1, "dean");
		assertEquals(1, cs.getId());
	}
	
	@Test
	public void testCustomerName() {
		Customer cs = new Customer(2, "Jiny");
		assertEquals("JinyXXXXX", cs.getName());
	}
}
