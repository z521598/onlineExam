package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by langshiquan on 17/6/12.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(String pdf) {
        return "home.html";
    }


}
