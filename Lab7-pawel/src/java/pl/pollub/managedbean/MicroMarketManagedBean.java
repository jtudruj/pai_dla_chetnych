/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub.managedbean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import pl.pollub.helper.MicroMarketHelper;

/**
 *
 * @author Wave
 */
@Named(value = "microMarketManagedBean")
@ApplicationScoped
public class MicroMarketManagedBean {
    
    MicroMarketHelper microMarketHelper;

    /**
     * Creates a new instance of microMarketHelperManagedBean
     */
    public MicroMarketManagedBean() {
        microMarketHelper = new MicroMarketHelper();
    }
    
    public List<String> getZipCodes() {
        return microMarketHelper.getZipCodes();
    }
    
}
