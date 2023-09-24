package com.example.spiringbootstart.controller;

import com.example.spiringbootstart.config.SpringBootConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/getConfig")
public class GetConfig {

    @Autowired
    private SpringBootConfig springBootConfig;

    @Value("${joge.name}")
    private  String name;

    @RequestMapping("/name")
    public String name(){
        return name;
    }

    @RequestMapping("/spingbootname")
    public String spingbootname() {
        return springBootConfig.getName();
    }

}
