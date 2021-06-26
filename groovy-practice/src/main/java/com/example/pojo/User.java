package com.example.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: springbooot-practice
 * @description:
 * @author: xrwang8
 * @create: 2021-06-26 11:21
 **/
@Data
public class User {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("名字")
    private String name;
    @ApiModelProperty("年龄")
    private int age;
    @ApiModelProperty("性别")
    private String gender;
}
