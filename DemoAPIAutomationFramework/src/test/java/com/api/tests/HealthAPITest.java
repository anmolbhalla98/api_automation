package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.api.base.HealthService;
import com.api.base.LoginHelper;
import io.restassured.response.Response;

public class HealthAPITest {

    @Test(description = "Verifying Health API without authentication")
    public void healthCheckWithoutToken() {
        HealthService healthService = new HealthService();
        Response response = healthService.getHealth(null);

        System.out.println("Response: " + response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 401, "Expected 401 Unauthorized");
        Assert.assertTrue(response.asString().contains("Authentication Required"), "Expected auth error message");
    }

    @Test(description = "Verifying Health API with authentication")
    public void healthCheckWithToken() {
        // Get token from login
        String token = LoginHelper.getToken("uday1234", "uday1234"); // replace with valid creds when available

        HealthService healthService = new HealthService();
        Response response = healthService.getHealth(token);

        System.out.println("Response: " + response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200, "Health check should return 200 OK");
        Assert.assertTrue(response.asString().contains("UP"), "Health status should be UP");
    }
}
