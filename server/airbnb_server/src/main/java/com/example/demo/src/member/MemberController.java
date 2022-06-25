package com.example.demo.src.member;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.member.model.*;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.config.BaseResponseStatus.POST_USERS_EMPTY_EMAIL;
import static com.example.demo.config.BaseResponseStatus.POST_USERS_INVALID_EMAIL;
import static com.example.demo.utils.ValidationRegex.isRegexEmail;

@RestController
@RequestMapping("/member") // controller 에 있는 모든 api 의 uri 앞에 기본적으로 들어감
public class MemberController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final MemberProvider memberProvider;
    @Autowired
    private final MemberService memberService;
    @Autowired
    private final JwtService jwtService;


    public MemberController(MemberProvider memberProvider, MemberService memberService, JwtService jwtService){
        this.memberProvider = memberProvider;
        this.memberService = memberService;
        this.jwtService = jwtService;
    }


    @ResponseBody
    @GetMapping("/{member_id}") // (GET) 127.0.0.1:9000/members/:member_id
    public BaseResponse<GetMemberRes> getMemberByMemberId(@PathVariable("member_id")int member_id) {
        try{
            GetMemberRes getMemberRes = memberProvider.getMemberById(member_id);
            return new BaseResponse(getMemberRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

}
