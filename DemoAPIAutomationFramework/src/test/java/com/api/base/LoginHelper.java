package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;

public class LoginHelper {

    // Logs in and returns a token
    public static String getToken(String username, String password) {
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest(username, password);

        Response response = authService.login(loginRequest);

        if (response.getStatusCode() == 200) {
            LoginResponse loginResponse = response.as(LoginResponse.class);
            return loginResponse.getToken();
        } else {
            throw new RuntimeException("Login failed → Status: "
                    + response.getStatusCode()
                    + " | Response: "
                    + response.asPrettyString());
        }
    }
}
