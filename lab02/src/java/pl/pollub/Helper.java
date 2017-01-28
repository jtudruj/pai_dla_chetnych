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
    
    private static final String FILE = "wyniki_lab02.txt";
    
    public static void writeResults(HashMap results) {
        try {
            File file = new File(FILE);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    System.out.println("Problem ze stworzeniem pliku " + e);
                }
                
            }
            PrintWriter writer = new PrintWriter(file);
            for (Iterator it = results.keySet().iterator(); it.hasNext();) {
                Object key = it.next();
                writer.println(key + ":" + results.get(key));
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Nie znaleziono pliku!");
        }
    }
    
    public static HashMap readResults() {
        String line = "";
        HashMap results = new HashMap();
        File file = new File(FILE);
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
            System.out.println("Blad odczytu pliku! " + e);
        }
        return results;
    }
}
