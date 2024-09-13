package com.loymark;

import com.loymark.dao.OrderDao;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        OrderDao orderDAO = new OrderDao();
        Long customerId = 1L; // Replace with the desired customer ID

        BigDecimal totalAmountSpent = orderDAO.calculateTotalAmountSpentByCustomer(customerId);
        System.out.println("Total amount spent by customer: " + totalAmountSpent);
    }
}
