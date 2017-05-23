package ngdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

import com.mongodb.DBCursor;
import com.mongodb.util.JSON;

import ngdemo.domain.Product;
import ngdemo.domain.User;
import ngdemo.service.Dao;
import ngdemo.service.UserService;


@Path("/")
public class UserRestService {

	@Path("/producten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void test() {
    	System.out.println("hello!!");
    }
}
