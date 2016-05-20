/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niklaus
 */
public class ResponseParser {

    public static String[] getCleanStringArray(String input) {
        String[] value;

        String tmp = input.replace("{", "");
        tmp = tmp.replace("}", "");
        tmp = tmp.replace("[", "");
        tmp = tmp.replace("]", "");
        tmp = tmp.replace("'", "");
        tmp = tmp.trim();
        value = tmp.split(", ");
        String[][] pairs = new String[value.length][1];
        for (int i = 0; i < value.length; i++) {
            pairs[i] = value[i].split(":");
        }
        return value;
    }

    public static String[] convertFromUnicode(String input) {
        String[] value;
        String tmp;
        try {
            byte[] bytes = input.getBytes("US-ASCII");
            tmp = new String(bytes, "UTF-8");
            tmp = tmp.trim();
            value = tmp.split(", ");
            return value;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ResponseParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
