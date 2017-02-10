/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub.helper;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import pl.pollub.hibernate.utils.HibernateUtil;
import pl.pollub.model.MicroMarket;

/**
 *
 * @author Wave
 */
public class MicroMarketHelper {
    
    Session session;
    
    public MicroMarketHelper() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List<String> getZipCodes() {
        Criteria criteria = session.createCriteria(MicroMarket.class);
        criteria.setProjection(Projections.property("zipCode"));
       return criteria.list();
    }
}
