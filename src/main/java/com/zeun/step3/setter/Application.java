package com.zeun.step3.setter;

import com.zeun.step3.setter.common.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        User user = context.getBean(User.class);
        user.sendMessage();
    }
}
