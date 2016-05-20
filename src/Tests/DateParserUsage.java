/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import GUI.MainWindow;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niklaus
 */
public class DateParserUsage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
                Process p;
                String date = "Mittwoch 15.04.2015 20:05";
                date = date.replace(' ', ';');
                String cmd[] = {"python", "parseDate.py", "--date=" + date};
                p = Runtime.getRuntime().exec(cmd);            
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                 
                String s = br.readLine();
                System.out.println(s);
            } catch (Exception ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}
