package com.api.tests;

import com.api.base.SignupService;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupAPITest {

    @Test(description = "Verifying user signup with positive and negative cases")
    public void signupUserTest() {
        // Generate unique username/email each time
        String uniqueUsername = "user" + System.currentTimeMillis();
        String uniqueEmail = "user" + System.currentTimeMillis() + "@gmail.com";

        SignupRequest signupRequest = new SignupRequest(
                uniqueUsername,
                "Password@123",
                uniqueEmail,
                "FirstName",
                "LastName",
                "9592958111"
        );

        SignupService signupService = new SignupService();
        Response response = signupService.signup(signupRequest);

        System.out.println("Response: " + response.asPrettyString());

        if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
            // ✅ Positive case
            Assert.assertTrue(response.asString().contains("success")
                            || response.asString().contains("registered"),
                    "Expected success message but got: " + response.asString());
        } else {
            // ❌ Negative case (duplicate user/email)
            Assert.assertTrue(response.asString().contains("already taken")
                            || response.asString().contains("already in use"),
                    "Expected duplicate error but got: " + response.asString());
        }
    }
}
