package com.zeun.step1.xmlconfig;

import com.zeun.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext("step1/xmlconfig/spring-context.xml");

        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println("member = " + member);
    }
}
