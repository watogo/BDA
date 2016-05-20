 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Mumi
 */
public class Settings {

    public Settings() {

    }

    public void saveProperty(String propertyName, String propertyValue) {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("config.properties");
            prop.setProperty(propertyName, propertyValue);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public String loadProp(String propertyName) {
        Properties prop = new Properties();
        InputStream input = null;
        String propertyValue = "";
        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            propertyValue = prop.getProperty(propertyName);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propertyValue;
    }
}
