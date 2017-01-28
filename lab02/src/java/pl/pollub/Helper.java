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
import java.util.Map;

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
    
    public static HashMap mergeHashMaps(HashMap input, HashMap output) {
        Iterator iterator = input.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry record = (Map.Entry)iterator.next();
            if(output.containsKey(record.getKey())) {
                output.put(record.getKey(), (Integer)output.get(record.getKey())+1);
            } else {
                output.put(record.getKey(), record.getValue());
            }
        }
        return output;
    }
    
    public static String hashMapToString(HashMap hashMap) {
        String result = "<ul>";
        
        Iterator iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry record = (Map.Entry) iterator.next();
            result += "<li>" + record.getKey() + ": " + record.getValue() + "</li>";
        }
        result += "</ul>";
        return result;
    }
    
        public static String hashMapToExcelString(HashMap hashMap) {
        String result = "";
        Iterator iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry record = (Map.Entry) iterator.next();
            result += record.getKey() + "\t" + record.getValue() + "\n";
        }
        return result;
    }
}
