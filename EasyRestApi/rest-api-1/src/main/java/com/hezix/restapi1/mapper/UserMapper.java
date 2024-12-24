package com.hezix.restapi1.mapper;


import com.hezix.restapi1.database.dto.UserCreateUpdateDto;
import com.hezix.restapi1.database.dto.UserReadDto;
import com.hezix.restapi1.database.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

public interface UserMapper<F,T> {
    T map(F object);
    default T map(F fromObject,T toObject){
        return toObject;
    }
}

