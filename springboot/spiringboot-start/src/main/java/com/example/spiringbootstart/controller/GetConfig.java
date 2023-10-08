package com.example.spiringbootstart.controller;

import com.example.spiringbootstart.config.SpringBootConfig;
import com.example.spiringbootstart.vo.Joger;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/getConfig")
public class GetConfig {

    @Autowired
    private SpringBootConfig springBootConfig;

    /** ObjectMapper */
    private ObjectMapper mapper;

    @Autowired
    public GetConfig(SpringBootConfig springBootConfig, ObjectMapper mapper) {
        this.springBootConfig = springBootConfig;
        this.mapper = mapper;
    }

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

    @GetMapping("/jackson")
    public Joger jackson() throws Exception {

        Joger joger = Joger.builder()
                .name("qinyi")
                .age(19)
                .address("shanghai")
                .registerTime(new Date())
                .build();

        String jsonjoger = mapper.writeValueAsString(joger);
        log.info("joger jackson: {}", jsonjoger);

        return mapper.readValue(jsonjoger, Joger.class);
    }

}
