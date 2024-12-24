package com.hezix.restapi1.service;

import com.hezix.restapi1.database.dto.UserCreateUpdateDto;
import com.hezix.restapi1.database.dto.UserReadDto;
import com.hezix.restapi1.database.repos.UserRepository;
import com.hezix.restapi1.mapper.UserCreateUpdateMapper;
import com.hezix.restapi1.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateUpdateMapper userCreateUpdateMapper;

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }
    public Optional<UserReadDto> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userReadMapper::map);
    }
    public List<UserReadDto> findAll() {
        return userRepository.findAll()
                .stream().map(userReadMapper::map).toList();
    }
    public boolean deleteById(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
    public boolean deleteByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
    public UserReadDto create(UserCreateUpdateDto userDto) {
        return Optional.of(userDto)
                .map(userCreateUpdateMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }
    public Optional<UserReadDto> update(Long id, UserCreateUpdateDto userDto) {
        return userRepository.findById(id)
                .map(entity-> userCreateUpdateMapper.map(userDto,entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }
}
