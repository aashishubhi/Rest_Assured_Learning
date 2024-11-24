package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExamples {

	//@Test
	public void testGet() {
		
		baseURI ="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name",  equalTo("George")).
			body("data.first_name",hasItems("George","Tobias","Lindsay"));//hasItem for single, hasItems for more than 1
		
	}
	
	@Test
	public void testPost() {
		
		//method1 to pass body as json
		//Map<String, Object> map = new HashMap<String, Object>(); //need to pass body (Post) in key value pair, key as string & value as Object
	
		//map.put("name", "Aashi"); //body in key value and libraries required like Json simple
		//map.put("job", "QA"); // body in key value
		
		//System.out.println(map);
		
		//JSONObject request = new JSONObject(map); // map data in JSon format
		
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
			post("/users").
		then().
			statusCode(201). 
			log().all(); 
	}
}

