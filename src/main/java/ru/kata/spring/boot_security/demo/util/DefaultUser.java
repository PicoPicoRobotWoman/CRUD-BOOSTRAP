package ru.kata.spring.boot_security.demo.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.model.*;

@Component
public class DefaultUser {
    
    @Autowired 
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    private void initialize(){
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.saveRole(roleAdmin);
        roleService.saveRole(roleUser);


        User admin = new User();
        admin.setAge(23);
        admin.setFistName("Nicole");
        admin.setLastName("Shein");
        admin.setEmail("Nicole@gmail.com");
        admin.setUsername("Nicole");
        admin.setPassword("TimBurton666");

        admin.addRole(roleAdmin);
        admin.addRole(roleUser);

        User user = new User();
        user.setFistName("user");
        user.setLastName("user");
        user.setEmail("user@gmail.com");
        user.setAge(1);
        user.setUsername("user");
        user.setPassword("user");
        user.addRole(roleUser);

        userService.add(admin);
        userService.add(user);


    }


}
