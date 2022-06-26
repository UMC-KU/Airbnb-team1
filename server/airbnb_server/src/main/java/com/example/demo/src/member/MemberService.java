package com.example.demo.src.member;


import com.example.demo.config.BaseException;

import com.example.demo.src.member.model.*;
import com.example.demo.utils.JwtService;
import com.example.demo.utils.SHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

// Service Create, Update, Delete 의 로직 처리
@Service
public class MemberService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MemerDao memerDao;
    private final MemberProvider memberProvider;
    private final JwtService jwtService;

    @Autowired
    public MemberService(MemerDao memerDao, MemberProvider memberProvider, JwtService jwtService) {
        this.memerDao = memerDao;
        this.memberProvider = memberProvider;
        this.jwtService = jwtService;
    }

}
