package com.zeun.step4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {

    private final Account account;

    // 구현체가 여러 개 있을 때 아래와 같이 Qualifier로 지정
    // 혹은 구현체에 Primary작성하여 우선 지정
    @Autowired
    public User(@Qualifier("businessAccount") Account account) {
        this.account = account;
    }

    public void doDeposit() {
        account.deposit(10000);
    }
}
