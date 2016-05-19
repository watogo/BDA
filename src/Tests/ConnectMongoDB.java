/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import com.mongodb.*;

/**
 *
 * @author Niklaus
 */
public class ConnectMongoDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost", 1234);
        client.getDatabase("test");
    }
    
}
