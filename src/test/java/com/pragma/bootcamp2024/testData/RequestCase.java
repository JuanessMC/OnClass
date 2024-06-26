package com.pragma.bootcamp2024.testData;

import org.springframework.http.HttpStatus;

public class RequestCase {
    private final String requestBody;
    private final HttpStatus expectedStatus;
    public RequestCase(String requestBody, HttpStatus expectedStatus) {
        this.requestBody = requestBody;
        this.expectedStatus = expectedStatus;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public HttpStatus getExpectedStatus() {
        return expectedStatus;
    }

}
