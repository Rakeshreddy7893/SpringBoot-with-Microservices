package com.recykal.controller;

import com.recykal.dto.EmailRequest;
import com.recykal.dto.OtpRequest;
import com.recykal.dto.OtpResponseDto;
import com.recykal.dto.OtpValidationRequest;
import com.recykal.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/otp")
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class OtpController {

    @Autowired
    private SmsService smsService;

    @Value("$(spring.mail.username)")
    private  String fromEmailId;

    Logger log = LoggerFactory.getLogger(OtpController.class);

    @GetMapping("/process")
    public String processSMS() {
        return "SMS sent";
    }

    @PostMapping("/send-otp")
    public OtpResponseDto sendOtp(@RequestBody OtpRequest otpRequest) {
        log.info("inside sendOtp :: "+otpRequest.getUsername());
        return smsService.sendSMS(otpRequest);
    }
    @PostMapping("/validate-otp")
    public ResponseEntity<?> validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
        log.info("inside validateOtp :: "+otpValidationRequest.getUsername()+" "+otpValidationRequest.getOtpNumber());
        boolean isValid= smsService.validateOtp(otpValidationRequest);
        if (isValid) {
            return ResponseEntity.ok(Map.of("message", "OTP is valid!"));
        } else {
            return ResponseEntity.status(400).body(Map.of("message", "Invalid OTP!"));
        }
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<?>  sendmail(@RequestBody EmailRequest emailRequest){
       boolean isSend= smsService.sendEmail(emailRequest.getTo(),emailRequest.getBody(),emailRequest.getSubject(),fromEmailId);
        if (isSend) {
            return ResponseEntity.ok(Map.of("message", "Email send Successfully!"));
        } else {
            return ResponseEntity.status(400).body(Map.of("message", "Error in send mail!"));
        }
    }
}


