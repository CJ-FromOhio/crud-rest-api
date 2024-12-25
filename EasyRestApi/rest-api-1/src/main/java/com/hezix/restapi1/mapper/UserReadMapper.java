package com.hezix.restapi1.mapper;

import com.hezix.restapi1.database.dto.UserCreateUpdateDto;
import com.hezix.restapi1.database.dto.UserReadDto;
import com.hezix.restapi1.database.entity.User;

import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements UserMapper<User, UserReadDto> {
    @Override
    public UserReadDto map(User entity) {
        return new UserReadDto(
                entity.getId(),
                entity.getUsername(),
                entity.getFirstname(),
                entity.getLastname(),
                entity.getRole(),
                entity.getEmail()
        );
    }

}
