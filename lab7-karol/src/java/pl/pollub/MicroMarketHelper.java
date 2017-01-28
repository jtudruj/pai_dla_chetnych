/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Karol Podolski
 */
public class MicroMarketHelper {
    
    SessionFactory sf;

    public MicroMarketHelper() {
        sf = HibernateUtil.getSessionFactory();
    }

    public List<String> getMicroMarkets() {
        Session s = sf.openSession();
        List<MicroMarket> microMarkets = (List<MicroMarket>) s.createQuery("from MicroMarket").list();
        s.close();
        List<String> zipCodes = new ArrayList<String>();
        for(MicroMarket microMarket: microMarkets) {
            zipCodes.add(microMarket.getZipCode());
        }
        return zipCodes;
    }
}
