/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Utils.ResponseParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niklaus
 */
public class TestResponseParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Process p;
            String cmd[] = {"python", "allitems.py"};
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = br.readLine();
            String[] value = ResponseParser.getCleanStringArray(s);
            for (String value1 : value) {
                //System.out.println(value1);
            }
        } catch (Exception ex) {
            Logger.getLogger(RunPythonScript.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
