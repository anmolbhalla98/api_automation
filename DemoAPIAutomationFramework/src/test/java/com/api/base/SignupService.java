package com.api.base;

import com.api.models.request.SignupRequest;
import io.restassured.response.Response;

public class SignupService extends BaseService {
    private static final String BASE_PATH = "/api/auth/";

    public Response signup(SignupRequest payload) {
        return requestSpecification
                .body(payload)
                .post(BASE_PATH+ "signup");
    }
}
