package com.example.demo.web.controllers;


import com.example.demo.business.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by davblain on 22.05.2017.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    String index()
    {
        return "index";

    }
    @RequestMapping("/arts")
    String arts()
    {
        return "arts";
    }









}
