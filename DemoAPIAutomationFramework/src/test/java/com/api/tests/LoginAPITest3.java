package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;

import io.restassured.response.Response;

public class LoginAPITest3 { // Following SOM (Service Object Model)

    @Test(description = "Verifying Login API with invalid credentials")
    public void loginTest() {
        // 1. Create login payload with invalid credentials
        LoginRequest loginRequest = new LoginRequest("uday1234", "uday1234");

        // 2. Call AuthService
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);

        // 3. Print the response
        System.out.println("Response: " + response.asPrettyString());

        // 4. Validate the API returns 401
        Assert.assertEquals(response.getStatusCode(), 401, "Expected 401 Unauthorized");

        // Optional: Check error message
        String errorMsg = response.jsonPath().getString("message");
        Assert.assertEquals(errorMsg, "The username or password you entered is incorrect", "Error message mismatch");
        // For Valid credentials
//        Assert.assertNotNull(loginResponse.getToken(), "Token should not be null");
//        Assert.assertEquals(loginResponse.getUsername(), "uday1234", "Username mismatch");
//        Assert.assertTrue(loginResponse.getRoles().contains("USER"), "Roles should contain USER");
//        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
//    
        
        }
    }

