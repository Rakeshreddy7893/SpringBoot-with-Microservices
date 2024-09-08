package com.recykal.dto;

public class OtpValidationRequest {

    private String username;
    private String otpNumber;

    public OtpValidationRequest(String username, String otpNumber) {
        this.username = username;
        this.otpNumber = otpNumber;
    }

    public OtpValidationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtpNumber() {
        return otpNumber;
    }

    public void setOtpNumber(String otpNumber) {
        this.otpNumber = otpNumber;
    }
}
