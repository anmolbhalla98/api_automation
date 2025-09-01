package com.api.tests;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;

import io.restassured.response.Response;

public class LoginAPITest3 {// We are following SOM in API Automation (Service Object Model.
	@Test(description = "Verifying Login API is Workng")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("uday1234", "uday1234");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);// Here we have created object of the Auth Service and calling the defined methods of that servive but the payload we are passing is hard-coded so we will be following POJO to overcome this.
		System.out.println(response.asPrettyString());
			}

}
