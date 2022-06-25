package com.example.demo.src.member;


import com.example.demo.src.member.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GetMemberRes getMemberById(int member_id){
        String getMemberByIdQuery = "select member_id,email,firstName,lastName,gender,profile_img_url,password,phone_num from Member where member_id=?";
        int getMemberByIdParams = member_id;
        return this.jdbcTemplate.queryForObject(getMemberByIdQuery,
                (rs, rowNum) -> new GetMemberRes(
                        rs.getInt("member_id"),
                        rs.getString("email"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("gender"),
                        rs.getString("profile_img_url"),
                        rs.getString("password"),
                        rs.getString("phone_num")),
                getMemberByIdParams);
    }

}



