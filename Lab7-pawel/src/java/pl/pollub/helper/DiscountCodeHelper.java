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
import pl.pollub.model.DiscountCode;

/**
 *
 * @author Wave
 */
public class DiscountCodeHelper {
    Session session;
    
    public DiscountCodeHelper() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List<Character> getDiscountCodes() {
        Criteria criteria = session.createCriteria(DiscountCode.class);
        criteria.setProjection(Projections.property("discountCode"));
       return criteria.list();
    }
}
