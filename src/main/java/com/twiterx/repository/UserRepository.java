package com.twiterx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twiterx.entity.User;

public interface UserRepository extends JpaRepository<User,Long>
{

	

}
