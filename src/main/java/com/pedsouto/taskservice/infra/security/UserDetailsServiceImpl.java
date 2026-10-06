package com.pedsouto.taskservice.infra.security;

import com.pedsouto.taskservice.client.UserClient;
import com.pedsouto.taskservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl {

    @Autowired
    private UserClient userClient;

    public UserDetails loadUserByUsername(String email, String token) {

        UserDto userDto = userClient.findUserByEmail(email, token);

        return User
                .withUsername(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
