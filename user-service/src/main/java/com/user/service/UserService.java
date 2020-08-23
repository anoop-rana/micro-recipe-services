package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.bean.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}

	public Optional<User> findUserById(long id) {
		return repo.findById(id);
	}

	public Optional<User> findUserByName(String name) {
		return repo.findByFirstName(name);
	}

	public User createOrUpdate(User user) {
		Optional<User> oldUser = repo.findByFirstName(user.getFirstName());
		if (oldUser.isPresent()) {
			User updateUser = oldUser.get();
			updateUser.setFirstName(user.getFirstName());
			updateUser.setLastName(user.getLastName());
			updateUser.setUserName(user.getUserName());
			updateUser.setPassword(user.getPassword());
			updateUser.setToken(user.getToken());
			
			return repo.save(updateUser);
		} else {
			return repo.save(user);
		}
	}

	public void deleteUser(long id) {
		repo.deleteById(id);
	}

}
