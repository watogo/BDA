/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

public class AddElementToCollection {

    public AddElementToCollection() {

    }

    public void addToCollection(String jsonString) {
        MongoClient mongoClient = new MongoClient(new ServerAddress(),
                Arrays.asList(MongoCredential.createCredential("admin", "test", "password".toCharArray())));
        try {
            for (String databaseName : mongoClient.listDatabaseNames()) {
                System.out.println("Database: " + databaseName);
            }
            MongoDatabase db = mongoClient.getDatabase("test");
            MongoCollection coll = db.getCollection("test2");
            //List<Document> myList = new ArrayList<>();
            
            Document doc = Document.parse(jsonString);
            //myList.add(doc);
            //coll.insertMany(myList);
            coll.insertOne(doc);
        } finally {
            mongoClient.close();
        }
    }
}
