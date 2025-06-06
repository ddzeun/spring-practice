package com.zeun.step2.annotation;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO {

    public void save() {
        System.out.println("회원 정보 저장");
    }
}
