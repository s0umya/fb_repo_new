package com.fetch.fbapp3.resources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fetch.fbapp3.model.User;
import com.fetch.fbapp3.service.GetUserDataService;
import com.fetch.fbapp3.service.LoginService;
/*import com.fetch.fbapp1.model.User;
import com.fetch.fbapp1.resources.Consumes;
import com.fetch.fbapp1.resources.GET;
import com.fetch.fbapp1.resources.Gson;
import com.fetch.fbapp1.resources.GsonBuilder;
import com.fetch.fbapp1.resources.JSONObject;
import com.fetch.fbapp1.resources.JsonMappingException;
import com.fetch.fbapp1.resources.JsonParseException;
import com.fetch.fbapp1.resources.POST;
import com.fetch.fbapp1.resources.Path;
import com.fetch.fbapp1.resources.Produces;
import com.fetch.fbapp1.service.LoginService;
import com.fetch.fbapp1.service.SignUpService;*/
import com.fetch.fbapp3.service.SignUpService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebService()
@Path("/user")
public class UserResource {

	private SignUpService s1;

	public UserResource() {
		s1 = new SignUpService();
	}

	@POST
    @Path("/login")
	@WebMethod(operationName = "insert")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public User userLogin(User user_obj) throws JsonParseException, JsonMappingException, IOException{
		
	//	String emailID=user_obj.getEmailID();
	//	String password=user_obj.getPassword();
	//	System.out.println("string is ="+ emailID +" "+ password);
		if(LoginService.loginUserService(user_obj))
		{
			System.out.println("retrun id is "+user_obj.getUserID());
			return user_obj;
		}
		
		return null;

	}//adduser method ends here

	
	@POST
    @Path("/fetch")
	@WebMethod(operationName = "insert")
	@Consumes({MediaType.APPLICATION_JSON})
    public User addUser(User user) throws JsonParseException, JsonMappingException, IOException{
		
		//System.out.println(user.getFname());
		//String output = "POST:Jersey say : " + msg;
		user.setEmailID(user.getEmailID());
		user.setPassword(user.getPassword());
	
		if(s1.addUserService(user))
		{
			return user;
		}
		return null;
        //return Response.status(200).entity(output).build();
       // return Response.ok().build();
	}//adduser method ends here
	@PUT
    @Path("/update")
	@WebMethod(operationName = "update")
	@Consumes({MediaType.APPLICATION_JSON})
    public boolean updateUser(User user) throws JsonParseException, JsonMappingException, IOException{
	
		System.out.println("updating user info");
		System.out.println("dob is here ="+user.getDate());
		System.out.println("town ="+ user.getTown());
		System.out.println("name="+user.getName());
		//String output = "POST:Jersey say : " + msg;
		user.setEmailID(user.getEmailID());
		user.setPassword(user.getPassword());
		user.setName(user.getName());
		user.setDate(user.getDate());
		user.setTown(user.getTown());
		
		
		if(s1.UpdateUserService(user))
		{
			return true;
		}
		return false;
       
	}//adduser method ends here

	
	
	
    @GET
    @Path("/retrive")
    @Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    @WebMethod(operationName = "retrive")
    //public User retrive(User u1) 
    //{
    public User retrive(@CookieParam("ID") int cookie) 
    {
    	
    	System.out.println("Inside retrive method ");
    	int ID=cookie;
    	//String password=user_obj.getPassword();
    			
    	//String emailID=user_obj.getEmailID();
		//String password=user_obj.getPassword();
		System.out.println("user is ="+ ID);
		//return GetUserDataService.getUserAllData(user_obj);
		 User u1= GetUserDataService.getUserAllData(ID);
		System.out.println("mailID="+u1.getEmailID());
	
		return u1;
		   
    }//retrive method ends here
	
	
}//class ends here
	

