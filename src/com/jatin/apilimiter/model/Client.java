package com.jatin.apilimiter.model;

import java.util.UUID;

public class Client {
    String id;
    String name;

    public Client(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
