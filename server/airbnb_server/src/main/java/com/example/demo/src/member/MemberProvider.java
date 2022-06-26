package com.example.demo.src.member;


import com.example.demo.config.BaseException;
import com.example.demo.src.member.model.*;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

//Provider : Read의 비즈니스 로직 처리
@Service
public class MemberProvider {

    private final MemerDao memerDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MemberProvider(MemerDao memerDao, JwtService jwtService) {
        this.memerDao = memerDao;
        this.jwtService = jwtService;
    }

    public GetMemberRes getMemberById(int member_id) throws BaseException{
        try{
            GetMemberRes getMemberRes = memerDao.getMemberById(member_id);
            return getMemberRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }


}
