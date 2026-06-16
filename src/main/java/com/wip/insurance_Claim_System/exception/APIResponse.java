package com.wip.insurance_Claim_System.exception;

public class APIResponse {

    private String message;

    public APIResponse() {
    }

    public APIResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}