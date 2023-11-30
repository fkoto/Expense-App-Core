package com.company.app.appcore.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("IdGenerator")
public class IdGenerator {

    public String generateKey(){
        return UUID.randomUUID().toString();
    }
}
