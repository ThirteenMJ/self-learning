package com.msb.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: thirteenmj
 * @date: 2022-09-21 13:44
 */
@RestController
public class MainController {

    @Value("${name}")
    private String gn;

    @GetMapping("/")
    public String list() {
        System.out.println(gn);
        return gn + "111";
    }

}
