package com.hezix.restapi1.mapper;

import com.hezix.restapi1.database.dto.UserCreateUpdateDto;
import com.hezix.restapi1.database.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreateUpdateMapper implements UserMapper<UserCreateUpdateDto, User>{
    @Override
    public User map(UserCreateUpdateDto object) {
        User user = new User();
        copy(object,user);

        return user;
    }

    @Override
    public User map(UserCreateUpdateDto fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(UserCreateUpdateDto from, User to) {
        to.setUsername(from.getUsername());
        to.setFirstname(from.getFirstname());
        to.setLastname(from.getLastname());
        to.setRole(from.getRole());
        to.setEmail(from.getEmail());
    }
}
