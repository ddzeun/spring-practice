package com.zeun.step2.javaconfig;

import com.zeun.common.MemberDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean(name = "memberDAO")
    public MemberDAO memberDAO() {

        return new MemberDAO();
    }
}
