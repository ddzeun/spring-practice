package com.zeun.step3.setter;

import com.zeun.step3.setter.common.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    private Notifier notifier;

    @Autowired
    public void setNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void sendMessage() {
        notifier.send("안녕하세요~!");
    }
}
