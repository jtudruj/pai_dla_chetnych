/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Karol Podolski
 */
@Named(value = "customerManagedBean")
@SessionScoped
public class CustomerManagedBean implements Serializable {

    CustomerHelper helper;
    private Customer current;
    DataModel customers;
    private int selectedItemIndex;

    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
        helper = new CustomerHelper();
    }

    public DataModel getCustomers() {
        if (customers == null) {
            customers = new ListDataModel(helper.getCustomers());
        }
        return customers;
    }

    public Customer getSelected() {
        if (current == null) {
            current = new Customer();
            selectedItemIndex = -1;
        }
        return current;
    }

    void recreateModel() {
        customers = null;
    }
    //metody nawigacji

    public String prepareEdit() {
        current = (Customer) getCustomers().getRowData();
        return "edit";
    }

    public String prepareList() {
        recreateModel();
        return "index";
    }

}
