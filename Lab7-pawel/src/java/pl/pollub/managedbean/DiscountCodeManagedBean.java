/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub.managedbean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import pl.pollub.helper.DiscountCodeHelper;

/**
 *
 * @author Wave
 */
@Named(value = "discountCodeManagedBean")
@Dependent
public class DiscountCodeManagedBean {

    DiscountCodeHelper discountCodeHelper;
    /**
     * Creates a new instance of DiscountCodeManagedBean
     */
    public DiscountCodeManagedBean() {
        discountCodeHelper = new DiscountCodeHelper();
    }
    
    public List<Character> getDiscountCodes() {
        return discountCodeHelper.getDiscountCodes();
    }
    
}
