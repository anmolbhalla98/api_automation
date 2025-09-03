package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;

public class LoginAPITest3 { // Following SOM (Service Object Model)

    @Test(description = "Verify Login API with invalid credentials")
    public void loginWithInvalidCredentials() {
        // 1. Create login payload with invalid creds
        LoginRequest loginRequest = new LoginRequest("uday1234", "wrongPassword");

        // 2. Call AuthService
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);

        System.out.println("Response: " + response.asPrettyString());

        // 3. Assertions for negative scenario
        Assert.assertEquals(response.getStatusCode(), 401, "Expected 401 Unauthorized");

        String errorMsg = response.jsonPath().getString("message");
        Assert.assertTrue(errorMsg.contains("incorrect"), "Unexpected error message: " + errorMsg);
    }

    @Test(description = "Verify Login API with valid credentials")
    public void loginWithValidCredentials() {
        // 🔴 Replace with a valid username + password once you get them
        LoginRequest loginRequest = new LoginRequest("uday1234", "uday1234");

        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);

        System.out.println("Response: " + response.asPrettyString());

        // 1. Status code should be 200
        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK");

        // 2. Deserialize response
        LoginResponse loginResponse = response.as(LoginResponse.class);

        // 3. Validate important fields
        Assert.assertNotNull(loginResponse.getToken(), "Token should not be null");
        Assert.assertEquals(loginResponse.getUsername(), "validUser", "Username mismatch");
        Assert.assertTrue(loginResponse.getRoles().contains("USER"), "Roles should contain USER");
    }
}
