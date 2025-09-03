package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.base.SignupService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;

public class SignupLoginChainTest {

    @Test(description = "Simple Signup -> Login chain")
    public void signupAndLoginChain() {

        // Step 1: Signup with basic fixed data
        SignupRequest signupRequest = new SignupRequest(
                "testuser",
                "Password@123",
                "testuser@gmail.com",
                "FirstName",
                "LastName",
                "9592958111"
        );

        SignupService signupService = new SignupService();
        Response signupResponse = signupService.signup(signupRequest);
        System.out.println("Signup Response: " + signupResponse.asPrettyString());

        // Check if signup was successful (200 or 201)
        Assert.assertTrue(
                signupResponse.getStatusCode() == 200 || signupResponse.getStatusCode() == 201,
                "Signup failed: " + signupResponse.asPrettyString()
        );

        // Step 2: Login with same credentials
        LoginRequest loginRequest = new LoginRequest("testuser@gmail.com", "Password@123");
        AuthService authService = new AuthService();
        Response loginResponse = authService.login(loginRequest);
        System.out.println("Login Response: " + loginResponse.asPrettyString());

        // Check login status
        Assert.assertEquals(loginResponse.getStatusCode(), 200, "Login failed");

        String token = loginResponse.jsonPath().getString("token");
        Assert.assertNotNull(token, "Token should not be null after login");

        System.out.println("Signup -> Login chain completed successfully!");
    }
}
