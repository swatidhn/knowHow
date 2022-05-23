package com.knowhow.admin.user;

import org.springframework.data.repository.CrudRepository;

import com.knowhow.common.entity.User;

public interface UserRepository extends CrudRepository<User,Integer> {

}
