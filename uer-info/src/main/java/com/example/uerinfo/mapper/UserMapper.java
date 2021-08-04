package com.example.uerinfo.mapper;

import com.example.uerinfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, Integer> {

}
