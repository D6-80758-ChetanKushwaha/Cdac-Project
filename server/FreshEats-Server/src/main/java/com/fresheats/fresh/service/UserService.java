package com.fresheats.fresh.service;

import com.fresheats.fresh.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserEntity addUser(UserEntity user);
}
