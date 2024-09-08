package com.recykal.service.interfaces;


import com.recykal.dto.LoginRequest;
import com.recykal.dto.Response;
import com.recykal.entity.User;

public interface IUserServices {

    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);
}
