package com.zeun.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        System.out.println("--- 가장 우선순위의 구현체 한 개 ---");
        User user = context.getBean(User.class);
        user.doDeposit();       // PersonalAccount에 @Primary가 붙어있지만 @Qualifier로 BusinessAccount를 지정해주었기 때문에 BusinessAccount가 우선 적용

        System.out.println("--- 리스트로 구현체 모두 ---");
        Users users = context.getBean(Users.class);
        users.depositAll();
    }
}
