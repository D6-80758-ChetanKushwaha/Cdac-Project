package com.fresheats.fresh.dao;

import com.fresheats.fresh.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, Long> {
}
