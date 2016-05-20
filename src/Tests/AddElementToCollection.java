/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Niklaus
 */
public class AddElementToCollection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String element = "{\"_type\": \"default\", "
                + "\"Datum_von\": [\"2016-03-30T18:00:00+00:00\"], "
                + "\"Titel\": [\"GOTO Night: Unplugged (You choose the topic)\"], "
                + "\"url\": \"http://techup.ch/2282/goto-night-unplugged-you-choose-the-topic\", "
                + "\"Ort\": [\"SIX Fintech Incubator F10, Foerrlibuckstr. 10, 8005 Zurich\"], "
                + "\"Beschreibung\": [\"You are hereby cordially invited to the second ever GOTO Agile Unplugged event where you can bring your burning topics to discuss with the friendliest bunch of agile practicioners in town. And there will be beer.\"], \"_cached_page_id\": \"549d89734327a2da42d798345ac7bc521cfed8da\", "
                + "\"Datum_bis\": [\"2016-03-30T23:00:00+00:00\"], "
                + "\"Direktlink\": [\"http://www.trifork.ch/2016/03/30/goto-night-unplug...\"], "
                + "\"Preis\": [\"Related Meetups: agile goto unplugged 1 person is attending this meetup Open in Google Maps\"], "
                + "\"_template\": \"41872dcb344a72891157dda9c40a82d739abef76\"}";
        
        
        MongoClient mongoClient = new MongoClient(new ServerAddress(), 
                Arrays.asList(MongoCredential.createCredential("admin", "test", "password".toCharArray())));
        try {
            for (String databaseName : mongoClient.listDatabaseNames()) {
                System.out.println("Database: " + databaseName);
            }
            MongoDatabase db = mongoClient.getDatabase("test");
            MongoCollection coll = db.getCollection("test2");
            Document doc = Document.parse(element);
            coll.insertOne(doc);
        } finally {
            mongoClient.close();
        }
    }
    
}
