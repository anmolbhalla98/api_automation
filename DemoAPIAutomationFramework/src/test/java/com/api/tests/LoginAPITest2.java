package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class LoginAPITest2 {
	@Test(description = "Verifying Login API is Workng")
	public void loginTest() {
				 Response response = given().baseUri("http://64.227.160.186:8080").header("Content-type","application/json")
				 .body("{\"username\": \"anmol1234\", \"password\": \"anmol1234\"}")
				 .post("/api/auth/login");
		 System.out.println(response.asPrettyString());
		 Assert.assertEquals(response.getStatusCode(), 401);
	}

}
