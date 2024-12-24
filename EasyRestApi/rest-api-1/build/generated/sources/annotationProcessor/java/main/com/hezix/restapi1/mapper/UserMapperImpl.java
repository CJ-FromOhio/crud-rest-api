package com.hezix.restapi1.mapper;

import com.hezix.restapi1.database.dto.UserReadDto;
import com.hezix.restapi1.database.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-24T12:07:05+0300",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.11.1.jar, environment: Java 17.0.12 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserReadDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserReadDto.UserReadDtoBuilder userReadDto = UserReadDto.builder();

        userReadDto.username( user.getUsername() );
        userReadDto.firstname( user.getFirstname() );
        userReadDto.lastname( user.getLastname() );
        userReadDto.role( user.getRole() );
        userReadDto.email( user.getEmail() );

        return userReadDto.build();
    }

    @Override
    public User toSource(UserReadDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( userDto.getUsername() );
        user.firstname( userDto.getFirstname() );
        user.lastname( userDto.getLastname() );
        user.role( userDto.getRole() );
        user.email( userDto.getEmail() );

        return user.build();
    }
}
