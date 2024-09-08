package com.recykal.service;

import com.recykal.config.TwilioConfig;
import com.recykal.dto.OtpRequest;
import com.recykal.dto.OtpResponseDto;
import com.recykal.dto.OtpStatus;
import com.recykal.dto.OtpValidationRequest;
import com.recykal.exception.OtpException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Slf4j
public class SmsService {

    Logger log = LoggerFactory.getLogger(SmsService.class);

    @Autowired
    private TwilioConfig twilioConfig;

    @Autowired
    private JavaMailSender javaMailSender;

    Map<String, String> otpMap = new HashMap<>();

    public OtpResponseDto sendSMS(OtpRequest otpRequest) {
        OtpResponseDto otpResponseDto;
        try {
            PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTwilioPhoneNumber());
            String otp = generateOTP();
            log.info("Inside sendSMS" +otp);
            System.out.println("otp = " + otp);
            String otpMessage = "Dear Customer, Your OTP is " + otp + ".";
            Message.creator(to, from, otpMessage).create();
            otpMap.put(otpRequest.getUsername(), otp);
            otpResponseDto = new OtpResponseDto(OtpStatus.DELIVERED, otpMessage);
        } catch (Exception e) {
            throw new OtpException("Failed to generate OTP: " + e.getMessage(), e);
        }
        return otpResponseDto;
    }

    public boolean validateOtp(OtpValidationRequest otpValidationRequest) {
        String username = otpValidationRequest.getUsername();
        if (otpMap.containsKey(username)) {
            String generatedOtp = otpMap.get(username);
            if (otpValidationRequest.getOtpNumber().equals(generatedOtp)) {
                otpMap.remove(username);
                return true;
            } else {
                throw new OtpException("OTP is invalid!");
            }
        } else {
            throw new OtpException("Username not found!");
        }
    }

    private String generateOTP() {
        return new DecimalFormat("000000").format(new Random().nextInt(999999));
    }

    public boolean sendEmail(String recipient,String body,String subject,String fromEmailId){
      try {
          SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
          simpleMailMessage.setFrom(fromEmailId);
          simpleMailMessage.setTo(recipient);
          simpleMailMessage.setText(body);
          simpleMailMessage.setSubject(subject);
          javaMailSender.send(simpleMailMessage);
          return  true;
      }
      catch (Exception e){
          throw new OtpException("Error in sending the email!");
      }

    }


}





