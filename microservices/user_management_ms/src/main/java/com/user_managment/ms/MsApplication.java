package com.user_managment.ms;

import com.user_managment.ms.Models.Role;
import com.user_managment.ms.Models.User;
import com.user_managment.ms.Repository.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MsApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MsApplication.class);

	@Autowired
	private UserRoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		Role user = new Role("User");
		Set ordinary_users = new HashSet<User>(){{
			add(new User("username1","123541", user));
			add(new User("username2","123541", user));
			add(new User("username3", "123541",user));
		}};
		user.setUsers(ordinary_users);

		Role admin = new Role("Admin");
		Set admin_users = new HashSet<User>(){{
			add(new User("username11", "123", admin));
			add(new User("username12","123", admin));
			add(new User("username13", "123", admin));
		}};

		admin.setUsers(admin_users);


		//roleRepository.deleteAll();
		//roleRepository.save(user);
		//roleRepository.save(admin);

		for (Role role : roleRepository.findAll()) {
			log.info(role.toString());
		}
	}
}
