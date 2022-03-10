package com.springbootcrudexample.dao;

import com.springbootcrudexample.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository <User,Integer>{
}
