package com.zeun.step4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Users {

    private final List<Account> accounts;

    @Autowired
    public Users(List<Account> accounts) {
        this.accounts = accounts;
    }

    // 구현체가 두 개 이상일 경우 자동으로 리스트로 주입, 순서대로 실행됨
    public void depositAll() {
        for (Account acc : accounts) {
            acc.deposit(1000);
        }
    }
}