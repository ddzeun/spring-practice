package com.zeun.step2.xmlconfig;

import com.zeun.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext("step2/xmlconfig/spring-context.xml");

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        memberDAO.save();
    }
}
