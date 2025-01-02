package com.jatin.designpatterns.criteriadesingpattern;

import java.util.List;
import java.util.stream.Collectors;

public class MaleCriteria implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        return persons.stream().filter(person -> person.getGender().equals("male")).collect(Collectors.toList());
    }
}
