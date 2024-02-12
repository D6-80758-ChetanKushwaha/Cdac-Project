package com.fresheats.fresh.service;

import com.fresheats.fresh.dao.UserDao;
import com.fresheats.fresh.entities.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpt implements UserService {

    private final UserDao userDao;
    public UserServiceImpt(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return this.userDao.save(user);
    }
}
