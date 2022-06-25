package com.example.demo.src.member.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class GetUserRes {
    private int userIdx;
    private String name;
    private String nickName;
    private String email;
}
