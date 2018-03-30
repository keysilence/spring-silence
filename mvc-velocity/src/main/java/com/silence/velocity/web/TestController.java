package com.silence.velocity.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Silence on 2018/3/29.
 */
@Controller
@RequestMapping(value = "/velocity", method = {RequestMethod.GET, RequestMethod.POST})
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestParam(value = "testString", required = false) String testString, Model view) {

        try {
            view.addAttribute("test", "Hi, I am demo!");
        } catch (Exception ex) {

        }

        return "mvc/demo";

    }

}
