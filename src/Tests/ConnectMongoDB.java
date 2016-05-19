/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

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
        MongoDatabase db = client.getDatabase("test");
        MongoCollection coll = db.getCollection("test");
        Document doc = new Document("x", 1);
        coll.insertOne(doc);
        doc.append("x", 2).append("x", 3);
        
    }
    
}
