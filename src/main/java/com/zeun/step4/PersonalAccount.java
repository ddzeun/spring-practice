package com.zeun.step4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PersonalAccount implements Account {

    @Override
    public void deposit(int amount) {
        System.out.println("개인 계좌에 " + amount + "입금");
    }
}
