package com.hezix.restapi1.database.dto;

import com.hezix.restapi1.database.entity.enums.Role;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReadDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private Role role;
    private String email;
}
