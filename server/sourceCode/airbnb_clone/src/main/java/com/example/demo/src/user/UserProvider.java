package com.example.demo.src.user;


import com.example.demo.config.BaseException;
import com.example.demo.src.user.model.GetUserFeedsRes;
import com.example.demo.src.user.model.GetUserInfoRes;
import com.example.demo.src.user.model.GetUserPostsRes;
import com.example.demo.src.user.model.GetUserRes;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

//Provider : Read의 비즈니스 로직 처리
@Service
public class UserProvider { 

    private final UserDao userDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserProvider(UserDao userDao, JwtService jwtService) {
        this.userDao = userDao;
        this.jwtService = jwtService;
    }

    public GetUserRes getUserByIdx(int userIdx) throws BaseException{
        try{
            GetUserRes getUserRes = userDao.selectUserByIdx(userIdx);
            return getUserRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public GetUserInfoRes getUsersInfoByIdx(int userIdx) throws BaseException {
        try {
            GetUserInfoRes getUserInfoRes = userDao.selectUserInfoByIdx(userIdx);
            return getUserInfoRes;
        } catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }

    }
    public GetUserFeedsRes retrieveUserFeeds(int userJwt, int userIdx) {
        boolean _isMyFeed = true;
        if(userJwt != userIdx)
            _isMyFeed = false;

        GetUserInfoRes getUserInfoRes = userDao.selectUserInfoByIdx(userIdx);
        List<GetUserPostsRes> getUserPostsResList = userDao.selectUserPostsByIdx(userIdx);

        GetUserFeedsRes getUserFeedsRes = new GetUserFeedsRes(_isMyFeed, getUserInfoRes, getUserPostsResList);

        return getUserFeedsRes;
    }

    public int checkUser(int userIdx) {
        return userDao.checkUser(userIdx);
    }




    public int checkEmail(String email) throws BaseException{
        try{
            return userDao.checkEmail(email);
        } catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }


}
