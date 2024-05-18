package Tests;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RestJsonExamples {

	@Test(priority = 0)
	public void test_Get() {

		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.asString());

		Assert.assertEquals(response.getStatusCode(), 200);
	}


	@Test
	public void Test_Post() {

		String URL = "https://reqres.in/api/users";
		JSONObject Request = new JSONObject();
		Request.put("Name", "Sayed");
		Request.put("Job", "Teacher");

		System.out.println(Request.toJSONString());

		 given().body(Request.toJSONString()).when().post(URL).then().statusCode(201).log().all();
	}



	@Test
	public void Test_Put() {

		String URL = "https://reqres.in/api/users/2";
		JSONObject Request = new JSONObject();
		Request.put("Name", "ahmed");
		Request.put("Job", "Teacher");

		System.out.println(Request.toJSONString());

		 given().body(Request.toJSONString()).when().put(URL).then().statusCode(200).log().all();
	}

	@Test
	public void Test_Patch() {

		String URL = "https://reqres.in/api/users/2";
		JSONObject Request = new JSONObject();
		Request.put("Name", "tamer");
		Request.put("Job", "Teacher");

		System.out.println(Request.toJSONString());

		 given().body(Request.toJSONString()).when().patch(URL).then().statusCode(200).log().all();
	}

	@Test
	public void Test_Delete() {

		String URL = "https://reqres.in/api/users/2";
		JSONObject Request = new JSONObject();
		Request.put("Name", "Sayed");
		Request.put("Job", "Teacher");

		System.out.println(Request.toJSONString());

		when().delete(URL).then().statusCode(204).log().all();
	}

}
