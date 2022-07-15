package ru.kata.spring.boot_security.demo.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import ru.kata.spring.boot_security.demo.repositoriy.RoleRepository;
import ru.kata.spring.boot_security.demo.repositoriy.UserRepository;

import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.model.*;

import java.util.HashSet;

@Component
public class DefaultUser {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;


    public DefaultUser(UserService userService, RoleRepository roleRepository, UserRepository userRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void initialize(){
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roleRepository.save(role1);
        roleRepository.save(role2);

        HashSet<Role> roles1 = new HashSet<>();
        roles1.add(role1);
        roles1.add(role2);

        HashSet<Role> roles2 = new HashSet<>();
        roles2.add(role2);

        User user1 = new User();
        user1.setAge(2);
        user1.setName("test");
        user1.setLastname("aLastName");
        user1.setUsername("a");
        user1.setPassword("$2a$12$syB9QiWRTiB6Sa/gUmOlTuCS/n3cKoZLyxWaIbOVb3Xm8OHspvolu");
        user1.setRoles(roles1);


        User user2 = new User();
        user2.setName("user");
        user2.setLastname("userLastName");
        user2.setAge(1);
        user2.setUsername("user");
        user2.setPassword("$2a$12$7AASG22SI4oFmfYA2GrJ3OPu1PAZgPa1kUqE1ZFJbdnKy/zNQjKBy");
        user2.setRoles(roles2);

        userRepository.save(user1);
        userRepository.save(user2);


    }


}
