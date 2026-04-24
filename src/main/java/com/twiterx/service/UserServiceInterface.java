package com.twiterx.service;

import java.util.List;
import java.util.Optional;

import com.twiterx.entity.User;

public interface UserServiceInterface 
{

	User save(User user);

	List<User> findAll();

	String updateById(long userId, User user);

	String deleteById(long userId);

	Optional<User> findById(long userId);

}
