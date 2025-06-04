package com.zeun.step1.javaconfig;

import com.zeun.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean(name = "member")
    public MemberDTO getMember() {

        return new MemberDTO("이지은", 99993);
    }
}
