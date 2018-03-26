package com.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParser;

import com.rest.model.Employee;
import com.rest.service.DbService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/hi")
public class RestDemo {
	
	List objList = null;
	Employee objEmployee = null;
	DbService objService = null;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Employee> getData(){
		 objService = new DbService();
		 objList = new ArrayList<Employee>();
		 objList = objService.getEmpData(); 
		// System.out.println("TEST");
		 objService = null; 
		 return objList;
	}
	
	@Path("/get/{k}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public Employee getDataByEmpId(@PathParam("k") int id){
	 objService = new DbService();
	 objEmployee = objService.getEmpById(id);
	//System.out.println("TESTouoio"+ id);	
		return objEmployee;
	}
	
	@Path("/del/{k}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Employee> getDelRecord(@PathParam("k") int id){
		objService = new DbService();
		objList = objService.delEmployee(id);
	//System.out.println("TESTasdas"+ id);	
	return objList;
	}
	
	@Path("/update/{k}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getUpdateRecord(@PathParam("k") int id){
		objService = new DbService();
		objEmployee = objService.updateEmployee(id);
		return objEmployee;
	}
	
	
	
	
	@Path("/getJson")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String getJsonClientData(String data) throws ParseException{
		JSONParser objParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) objParser.parse(data);
		JSONArray objArray = (JSONArray) jsonObject.get("results");
		//System.out.println("Json data"+ objArray);
		JSONObject jsonobj_1 = null;
		for(int i=0;i<objArray.size();i++)
		{
		jsonobj_1 = (JSONObject)objArray.get(i);
		//System.out.println("Place_id" +jsonobj_1.get("place_id"));
		}
		return (String) jsonobj_1.get("place_id");
	}
	
	@Path("/addEmp")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String add(String data){
		System.out.println("Add element...");
		System.out.println(data);
		return "Done";
	}
	
	
	
	
}
