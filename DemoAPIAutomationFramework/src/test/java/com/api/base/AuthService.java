package com.api.base;

import com.api.models.request.LoginRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {// So here we are creating class for our Authentication Service and the methods/endpoints inside this service we will create and test
	 private static final String BASE_PATH="/api/auth/";
	 public Response login(LoginRequest payload) {
		 return postRequest(payload,BASE_PATH + "login");
	 }

}
