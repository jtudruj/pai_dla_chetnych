/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub.helper;

import java.util.List;
import pl.pollub.hibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.pollub.model.Customer;

/**
 *
 * @author Wave
 */
public class CustomerHelper {
    
    Session session;
    
    public CustomerHelper() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List<Customer> getCustomers() {
       return session.createQuery("from Customer").list();
    }
    
    public void saveOrUpdateCustomer(Customer customer) {
        Transaction transaction = this.session.getTransaction();
        transaction.begin();
        this.session.saveOrUpdate(customer);
        transaction.commit();
    }

}
