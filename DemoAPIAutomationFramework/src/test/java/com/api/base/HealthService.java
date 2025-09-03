package com.api.base;

import io.restassured.response.Response;

public class HealthService extends BaseService {
    private static final String BASE_PATH = "/actuator/health";

    public Response getHealth(String token) {
        return requestSpecification
                .header("Authorization", "Bearer " + token)
                .when()
                .get(BASE_PATH);
    }
}
