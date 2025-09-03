package com.api.base;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { //Wrapper for Rest Assured!
	// Base Uri
	//Creating The Request
	// Handling The Response
	private static final String BASE_URL="http://64.227.160.186:8080";// We  often write constants in Upper Case and we use final keyword and if we use final we always use static in variables private we use to abstract
	protected RequestSpecification requestSpecification;
	public BaseService() {
		requestSpecification=given().baseUri(BASE_URL);
	}
	protected Response postRequest(Object payload, String endpoint) {// we are using super class reference here just to couple loosely so per request if any other payload request is coming it should take so like this we are making this to happen(POJO)
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
		}
}
