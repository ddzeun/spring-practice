package com.zeun.step3.constructor;

import com.zeun.step3.constructor.common.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    private final Notifier notifier;


    // 생성자가 한개면 @Autowired 생략가능
    @Autowired
    public User(Notifier notifier) {
        this.notifier = notifier;
    }

    public void sendMessage() {
        notifier.send("안녕~~하세요!");
    }
}
