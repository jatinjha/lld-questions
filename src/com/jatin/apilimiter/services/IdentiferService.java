package com.jatin.apilimiter.services;

import com.jatin.apilimiter.model.Client;
import com.jatin.apilimiter.model.Identifier;
import com.jatin.apilimiter.model.Rule;

import java.util.HashMap;
import java.util.Map;

public class IdentiferService {

    Map<String, Map<String,Rule>> clientVsIdentifierVsRules;

    public IdentiferService(){
        clientVsIdentifierVsRules = new HashMap<>();
    }

    public Boolean isValidIdentifier(Client client , Identifier identifier){
        return true;
    }

    public void addRule(Client client , Identifier identifier , Rule rule) throws Exception {
        Map<String,Rule> identifierVsRules = clientVsIdentifierVsRules.getOrDefault(client.getId(),new HashMap<>());
        if(identifierVsRules.isEmpty()){
            throw new Exception("invalid clientid");
        }

        identifierVsRules.put(identifier.getId(),rule);
    }
}
