package com.hezix.restapi1.web.controllers;

import com.hezix.restapi1.database.dto.UserCreateUpdateDto;
import com.hezix.restapi1.database.dto.UserReadDto;
import com.hezix.restapi1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MainController {

    private final UserService userService;

    @GetMapping("/{id}")
    public Optional<UserReadDto> findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
    @GetMapping("/")
    public List<UserReadDto> findAll() {
        return userService.findAll();
    }
    @GetMapping
    public Optional<UserReadDto> findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        return userService.deleteById(id)
                ? noContent().build()
                : notFound().build();
    }
    @DeleteMapping("/delete/")
    public ResponseEntity<?> deleteByUsername(@RequestParam String username) {
        return userService.deleteByUsername(username)
                ? noContent().build()
                : notFound().build();
    }
    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable("id") Long id,
                              @Validated @RequestBody UserCreateUpdateDto user) {
        return userService.update(id,user)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserReadDto create(@Validated @RequestBody UserCreateUpdateDto user) {
        return userService.create(user);
    }
}
