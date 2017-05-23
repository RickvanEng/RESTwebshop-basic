package ngdemo.service;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import ngdemo.domain.Product;

public class Dao {
	
	public Dao() {
		
	}
	
	MongoClient 		mongo;
	DB 					db;
	DBCollection 		collection;
	DBCursor 			cursor;
	BasicDBObject 		dbObject;
	BasicDBObject 		searchQuery;
	
	public void dbConnect () {
		try {
			mongo = new MongoClient( "localhost" , 27017 );
			
			db = mongo.getDB("webshop");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BasicDBObject getSingleProduct(String pName) {
		
		collection = db.getCollection("products");
		searchQuery = new BasicDBObject();
		searchQuery.put("productName", pName);

		cursor = collection.find(searchQuery);

		dbObject = (BasicDBObject) cursor.next();
		
		return dbObject;
	}
	
	public DBCursor getAllProducts() {
		//System.out.println("in get all producten from db 1");
		
		collection = db.getCollection("products");
		DBCursor cursor = collection.find();
//		while (cursor.hasNext()) {
//		   DBObject obj = cursor.next();
//		   System.out.println("yoyo1" + obj);
//		}
		
		return cursor;
	}

	public DBCursor getCart() {
		//System.out.println("in get all producten from db 1");
		
		collection = db.getCollection("cart");
		DBCursor cursor = collection.find();
//		while (cursor.hasNext()) {
//		   DBObject obj = cursor.next();
//		   System.out.println("yoyo1" + obj);
//		}
		
		return cursor;
	}
	
	public void removeProductFromCart(JSONObject product) {
		try {
			collection = db.getCollection("cart");
			System.out.println(product.toString());
			//JSONArray array = product.get("product").getJSONArray();
//			
//			DBCursor cursor = collection.find();
//			while (cursor.hasNext()) {
//				BasicDBObject jsonObject = (BasicDBObject) cursor.next();
//
//				
//			   product.setProductName((String) jsonObject.get("productName"));
//			   product.setDescription((String) jsonObject.get("description"));
//			   product.setId((String) jsonObject.get("_id"));
//			   //product.setCategory(jsonObject.getArray("category"));
//			   product.setPrice(jsonObject.getInt("price"));
//			   
//			   
//			   //System.out.println("added product: " + product);
//			   
//			   productList.add(product);
//		}
			DBObject dbObject = (DBObject) collection.find();
			
			//String name = product.get("productName").toString();
			
//			BasicDBObject document = new BasicDBObject();
//			document.put("productName", "Ball");

			
			//collection.remove("productName": "ball", true );
			//DBCursor cursor = collection.find();
			//DBObject doc = collection.findOne();
			//db.getCollection("Cart").remove(o)
			
			//collection.remove({ "user_id" : "testuser" }, 1);
			
		}catch (Exception e) {
			System.out.println(e);
			 e.printStackTrace();
		}
	}
	
	public void postProductInCart(String product) {
		
		collection = db.getCollection("cart");
		
		DBObject dbObject = (DBObject)JSON.parse(product);

		collection.insert(dbObject);

//		DBCursor cursorDoc = collection.find();
//		while (cursorDoc.hasNext()) {
//			System.out.println(cursorDoc.next());
//		}
	}
	
	
	//Hier komen alle methods die data ophalen uit de database. 
}


//List<String> dbs = mongo.getDatabaseNames();
//for(String db : dbs){
//System.out.println(db);
//}



//als er meer objecten terugkomen kan je loopen
//while (cursor.hasNext()) {
//
//	BasicDBObject dbObject = (BasicDBObject) cursor.next();
//	System.out.println(dbObject.get("productName"));
//}	

//BasicDBObject dbObject = (BasicDBObject) cursor.next();
//System.out.println(dbObject);
