package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	@Test(description = "Verifying Login API is Workng")
	public void loginTest() {
		baseURI="http://64.227.160.186:8080"; //Either we can pass baseURI like this 
		RequestSpecification x = RestAssured.given();
		RequestSpecification y = x.header("Content-type","application/json");
		RequestSpecification z = y.body("{\"username\": \"anmol1234\", \"password\": \"anmol1234\"}");

		// Here were using return-type chaining to reuse the request calls by using RequestSpecification interface!		 

		 Response response =z.post("/api/auth/login");
		 System.out.println(response.asPrettyString());
		 Assert.assertEquals(response.getStatusCode(), 401);
	}

}
