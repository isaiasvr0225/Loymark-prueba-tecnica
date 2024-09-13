package com.loymark.dao;

import com.loymark.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;

public class OrderDao {

    public BigDecimal calculateTotalAmountSpentByCustomer(Long customerId) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            String hql = "SELECT SUM(o.totalAmount) FROM Order o WHERE o.customer.id = :customerId";
            Query<BigDecimal> query = session.createQuery(hql, BigDecimal.class);
            query.setParameter("customerId", customerId);
            return query.getSingleResult();


            /*
            This is the equivalent SQL query:

            SELECT SUM(o.total_amount)
            FROM orders o
            JOIN customers c ON o.customer_id = c.id
            WHERE c.id = 1; // Replace with the desired customer ID

            Using Spring, we can use Spring Data Projections with Hibernate Native Query to achieve the same result.
             */
        } finally {
            session.close();
        }
    }
}
