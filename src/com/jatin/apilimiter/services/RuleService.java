package com.jatin.apilimiter.services;

import com.jatin.apilimiter.model.Client;
import com.jatin.apilimiter.model.Identifier;
import com.jatin.apilimiter.model.Rule;

public class RuleService {
    IdentiferService identiferService;

    public RuleService(){
        this.identiferService = new IdentiferService();
    }

    public void addRule(Client client , Identifier identifier , Rule rule) throws Exception {
        identiferService.addRule(client,identifier,rule);
    }

    public Boolean isValidIdentifier(Client client , Identifier identifier){
        return identiferService.isValidIdentifier(client,identifier);
    }

}
