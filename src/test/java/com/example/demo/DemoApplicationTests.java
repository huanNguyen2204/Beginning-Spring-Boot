package com.example.demo;

import com.example.demo.mappers.UserMapper;
import org.h2.engine.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAllUsers() {
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(users.isEmpty());
	}

	@Test
	public void findUserById() {
		User user = userMapper.findUsersbyId(1);
		assertNotNull(user);
	}

	@Test
	public void createUser() {
		User user = new User(0, "geogre", "geogre@gmail.com");
		userMapper.insertUser(user);
		User newUser = userMapper.findUsersbyId(user.getId());
		assertEquals("geogre", newUser.getName());
		assertEquals("geogre@gmail.com", newUser.getEmail());
	}
}
