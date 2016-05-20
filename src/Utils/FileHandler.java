/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mumi
 */
public class FileHandler {

    private String pathToFile;
    private Settings settings;

    public FileHandler(String pathToFile) {
        this.pathToFile = pathToFile;
        settings = new Settings();
    }

    public void deleteFromFile(String text) {

    }

    public void appendToFile(String text) {

        FileWriter fw = null;

        try {
            fw = new FileWriter(pathToFile, true);
            fw.write(text + "\r\n");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<String> getFileContent() {
        String content = "";
        ArrayList<String> myFormate = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(new File(pathToFile));
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                myFormate.add(s);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return myFormate;
    }

    public void removeLineFromFile(String lineToRemove) {

        try {

            File inFile = new File(pathToFile);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(pathToFile));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Could not rename file");
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setProp(String value) {
        settings.saveProperty("StandardFormat", value);
    }

    public String getProp(String propName) {
        return settings.loadProp(propName);
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

}
