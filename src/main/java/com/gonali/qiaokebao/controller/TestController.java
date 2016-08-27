package com.gonali.qiaokebao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/8/27.
 */
@Controller
@RequestMapping("/")
public class TestController {


    @RequestMapping
    public String hello() {

        return "index";
    }


}
