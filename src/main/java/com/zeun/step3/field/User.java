package com.zeun.step3.field;

import com.zeun.step3.common.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    private Notifier notifier;

    public void sendMessage() {
        notifier.send("안녕하세요!");
    }
}
