package com.user;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.user.bean.User;
import com.user.repository.UserRepository;


//@EnableEurekaClient
@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner{

	@Autowired
	UserRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.saveAll(Arrays.asList(
				new User("Kishan","Sharma", "kishan123", "pass@123", "kishan123_token"),
				new User("Gopal","Sharma", "gopal453", "pas@453", "gopal453_token"),
				new User("Rohan","Methi", "rohan64", "rohan@64", "rohan64_token"),
				new User("Deepika","tondan", "deepika123", "deepika123", "deepika123_token"),
				new User("Chandani","Sharma", "chandani54", "chandani@54", "chandani54_token")
				));
	}

}
