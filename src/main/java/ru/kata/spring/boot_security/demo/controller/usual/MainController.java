package ru.kata.spring.boot_security.demo.controller.usual;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping
public class MainController {

    @GetMapping("/")
    public String mainPage() {

        return "/index";
    }

}
