/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PrintFristElementOfCollection {

    public static void main(String[] args) throws UnknownHostException {

        MongoClient mongoClient = new MongoClient(new ServerAddress(),
                Arrays.asList(MongoCredential.createCredential("admin", "test", "password".toCharArray())));
        try {
            for (String databaseName : mongoClient.listDatabaseNames()) {
                System.out.println("Database: " + databaseName);
            }
            MongoDatabase db = mongoClient.getDatabase("test");
            MongoCollection coll = db.getCollection("test");
            System.out.println(coll.find().first());
        } finally {
            mongoClient.close();
        }
    }
}
