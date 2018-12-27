package com.user.post;

import com.user.post.controller.UserController;
import com.user.post.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class BootMongoKafkaApplication.
 */
@SpringBootApplication
public class BootMongoKafkaApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(BootMongoKafkaApplication.class, args);

		UserController userController = ctx.getBean(UserController.class);

		List<User> users = userController.getUsers();

		//users.stream().filter(user -> user.getUserId()==105).forEach(System.out::println);

		/** Iterating values to match user id and post the same object */
		users.stream().filter(user -> user.getUserId() == 105).forEach(user -> {
			userController.postUserObject(user);
		});

	}

}

