/**
 * 
 */
package com.awsaces.learn.mongodb;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author aagarwal
 *
 */
public class Insert {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017); 
		MongoDatabase mongoDatabase = mongoClient.getDatabase("learn-mongodb");
		MongoCollection<Document> testCollection = mongoDatabase.getCollection("test");
		testCollection.drop();
		
		testCollection.insertOne(new Document().append("x", 1));
		
		List<Document> docList = Arrays.asList(
									new Document("A",1)
								,	new Document("B",2)
								,	new Document("C",3)
								,	new Document("D",4)
								,	new Document("E",5)
								);
		testCollection.insertMany(docList);
		
		mongoClient.close();
	}
}
