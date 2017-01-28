/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub;

import java.util.List;

/**
 *
 * @author Karol Podolski
 */
public class Main {

    public static void main(String[] args) {
        CustomerHelper market = new CustomerHelper();
        List<Customer> list = market.getCustomers();
        for (Customer i : list) {
            System.out.println(i);
        }
        DiscountCodeHelper d = new DiscountCodeHelper();
        List<Character> discountCodes = d.getDiscountCode();
        for (Character i : discountCodes) {
            System.out.println(i);
        }
        MicroMarketHelper m = new MicroMarketHelper();
        List<String> markets = m.getMicroMarkets();
        for (String i : markets) {
            System.out.println(i);
        }
    }
}
