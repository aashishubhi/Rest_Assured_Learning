package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {

	@Test
	public void testPut() {
		
		JSONObject request1 = new JSONObject();
		
		request1.put("name", "Aashi");
		request1.put("job", "QA");
		
		System.out.println(request1.toJSONString()); // print body in Json format
		
		baseURI ="https://reqres.in/api";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON). //sending Content type as Json
			accept(ContentType.JSON). // receive Json
			body(request1.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).  
			log().all(); 
	}
	
	@Test
	public void testPatch() {
		
		JSONObject request1 = new JSONObject();
		
		request1.put("name", "Aashi");
		request1.put("job", "QA");
		
		System.out.println(request1.toJSONString()); // print body in Json format
		
		baseURI ="https://reqres.in";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON). //sending Content type as Json
			accept(ContentType.JSON). // receive Json
			body(request1.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).  
			log().all(); 
	}
	
	@Test
	public void testDelete() {
		
		baseURI ="https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204).  
			log().all(); 
	}
	
	
	
	
}
