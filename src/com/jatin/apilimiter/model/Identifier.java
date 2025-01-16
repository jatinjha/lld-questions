package com.jatin.apilimiter.model;

import java.util.UUID;

public class Identifier {
    String key;
    String id;

    public Identifier(String key) {
        this.key = key;
        this.id = UUID.randomUUID().toString();
    }

    public String getKey() {
        return key;
    }

    public String getId() {
        return id;
    }
}
