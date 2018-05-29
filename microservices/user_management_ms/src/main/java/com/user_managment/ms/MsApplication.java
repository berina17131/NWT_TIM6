package com.user_managment.ms;

import com.user_managment.ms.Models.Role;
import com.user_managment.ms.Models.User;
import com.user_managment.ms.Repository.UserRoleRepository;
import com.user_managment.ms.Security.UpdatableBCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class MsApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MsApplication.class);
    private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(11);

    @Autowired
    private UserRoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Role user = new Role("ROLE_USER");
        User user1 = new User("Emir", "Barucija", "emir", bcrypt.hash("password"), user);
        Set ordinary_users = new HashSet<User>() {{
            add(user1);
        }};
        user.setUsers(ordinary_users);

        Role admin = new Role("ROLE_ADMIN");
        User user2 = new User("Amra", "Mujcinovic", "amra", bcrypt.hash("password"), admin);
        Set admin_users = new HashSet<User>() {{
            add(user2);
        }};
        admin.setUsers(admin_users);

        roleRepository.deleteAll();
        roleRepository.save(user);
        roleRepository.save(admin);

        for (Role role : roleRepository.findAll()) {
            log.info(role.toString());
        }
    }
}
