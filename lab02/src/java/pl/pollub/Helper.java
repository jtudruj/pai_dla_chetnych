/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author linuxlite
 */
public class Helper {
    public static void writeResults(HashMap results) {
        try {
//            FileWriter fw = new FileWriter("wyniki.txt");
            PrintWriter writer = new PrintWriter("wyniki.txt", "UTF-8");
            for (Iterator it = results.keySet().iterator(); it.hasNext();) {
                Object key = it.next();
//                fw.write(key + ":" + results.get(key) + "\n");
                writer.println(key + ":" + results.get(key));
            }
//            fw.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku!");
        }
    }
    
    public static HashMap readResults() {
        String line = "";
        HashMap results = new HashMap();
        File file = new File("wyniki.txt");
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis));
            while ((line = br.readLine()) != null) {                
                String[] elem = line.split(":");
                results.put(elem[0], Integer.parseInt(elem[1]));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Blad odczytu pliku!");
        }
        return results;
    }
}
