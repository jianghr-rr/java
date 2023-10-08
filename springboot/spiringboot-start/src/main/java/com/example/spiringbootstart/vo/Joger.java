package com.example.spiringbootstart.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Joger {
    private String name;
    private int age;

    @JsonIgnore
    private String address;

    @JsonProperty("rt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;
}
