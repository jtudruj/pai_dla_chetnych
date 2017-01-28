/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Karol Podolski
 */
@ManagedBean(name = "customerHelper")
@RequestScoped
public class CustomerHelper {

    SessionFactory sf;

    public String getEditAction(int id) {
        Customer customerForEdit = getCustomer(id);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Customer customer = (Customer) facesContext.getApplication()
                .createValueBinding("#{customer}").getValue(facesContext);
        customer.setAddressline1(customerForEdit.getAddressline1());
        customer.setAddressline2(customerForEdit.getAddressline2());
        customer.setCity(customerForEdit.getCity());
        customer.setCreditLimit(customerForEdit.getCreditLimit());
        customer.setCustomerId(customerForEdit.getCustomerId());
        customer.setDiscountCode(customerForEdit.getDiscountCode());
        customer.setEmail(customerForEdit.getEmail());
        customer.setFax(customerForEdit.getFax());
        customer.setName(customerForEdit.getName());
        customer.setPhone(customerForEdit.getPhone());
        customer.setState(customerForEdit.getState());
        customer.setZip(customerForEdit.getZip());
        return "dodaj";
    }

    public CustomerHelper() {
        sf = HibernateUtil.getSessionFactory();
    }

    public List<Customer> getCustomers() {
        Session s = sf.openSession();
        List<Customer> customers = (List<Customer>) s.createQuery("from Customer").list();
        s.close();
        return customers;
    }

    public Customer getCustomer(int id) {
        Session s = sf.openSession();
        List<Customer> customers = (List<Customer>) s.createQuery("from Customer where customer_id=" + id).list();
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }
    }
    public void update(Customer c) {
        Session s = sf.openSession();
        s.getTransaction().begin();
        s.saveOrUpdate(c);
        s.getTransaction().commit();
    }
    public void addCustomer(Customer c) {
        Session s = sf.openSession();
        s.getTransaction().begin();
        s.saveOrUpdate(c);
        s.getTransaction().commit();
    }
}
