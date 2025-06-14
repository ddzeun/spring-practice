package com.zeun.step4;

import org.springframework.stereotype.Component;

@Component
public class BusinessAccount implements Account {

    @Override
    public void deposit(int amount) {

        System.out.println("비즈니스 계좌에 " + amount + "원 입금");
    }
}
