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
public class DiscountCodeHelper {

    SessionFactory sf;

    public DiscountCodeHelper() {
        sf = HibernateUtil.getSessionFactory();
    }

    public List<Character> getDiscountCode() {
        Session s = sf.openSession();
        List<DiscountCode> c = (List<DiscountCode>) s.createQuery("from DiscountCode").list();
        s.close();
        List<Character> codes = new ArrayList<Character>();
        for(DiscountCode dc: c) {
            codes.add(dc.getDiscountCode());
        }
        return codes;
    }

}
