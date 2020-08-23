package com.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByFirstName(String name);
}
