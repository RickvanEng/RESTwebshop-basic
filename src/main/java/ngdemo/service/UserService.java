package ngdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import ngdemo.domain.Product;
import ngdemo.domain.User;

public class UserService {

    public User getDefaultUser() {
        User user = new User();
        user.setFirstName("JonFromREST");
        user.setLastName("DoeFromREST");
        return user;
    }
    
    public void postProductInCart(String product) {
    	Dao dao = new Dao();
    	dao.dbConnect();
    	dao.postProductInCart(product);
    }
    
    public void removeProductFromCart(JSONObject product) {
    	Dao dao = new Dao();
    	dao.dbConnect();
    	dao.removeProductFromCart(product);
    }
	
//	public Product getProduct() {
//		Product productInfo = new Product();
//		Dao dao = new Dao();
//		dao.dbConnect();
//		BasicDBObject daoObject = dao.getSingleProduct("Rope");
//		
//		productInfo.setProductName((String) daoObject.get("productName"));
//		//productInfo.setCategory(dao.getCategory());
//		productInfo.setDescription((String) daoObject.get("description"));
//		productInfo.setPrice(daoObject.getInt("price"));
//		
//		return productInfo;
//	}

	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> productList = new ArrayList<Product>();
		Dao dao = new Dao();
		dao.dbConnect();
		DBCursor cursor = dao.getAllProducts();
		
		System.out.println("hij is terug");
		while (cursor.hasNext()) {
				BasicDBObject jsonObject = (BasicDBObject) cursor.next();
			   //System.out.println("yoyo2" + jsonObject);
			   
			   Product product = new Product();
			   product.setProductName((String) jsonObject.get("productName"));
			   product.setDescription((String) jsonObject.get("description"));
			   //product.setId((String) jsonObject.get("_id"));
			   //product.setCategory(jsonObject.getArray("category"));
			   product.setPrice(jsonObject.getInt("price"));
			   
			   
			   //System.out.println("added product: " + product);
			   
			   productList.add(product);
		}
		
		return productList;
	}

	public ArrayList<Product> getCart() {
		ArrayList<Product> productList = new ArrayList<Product>();
		Dao dao = new Dao();
		dao.dbConnect();
		DBCursor cursor = dao.getCart();

		while (cursor.hasNext()) {
			BasicDBObject jsonObject = (BasicDBObject) cursor.next();

			Product product = new Product();
			product.setProductName((String) jsonObject.get("productName"));
			product.setDescription((String) jsonObject.get("description"));
			// product.setCategory(jsonObject.getArray("category"));
			product.setPrice(jsonObject.getInt("price"));

			productList.add(product);
		}

		return productList;
	}
}