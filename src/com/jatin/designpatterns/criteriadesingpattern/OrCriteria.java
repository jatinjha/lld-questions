package com.jatin.designpatterns.criteriadesingpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrCriteria implements Criteria{
    private final Criteria criteriaOne;
    private final Criteria criteriaTwo;

    public OrCriteria(Criteria criteriaOne , Criteria criteriaTwo){
        this.criteriaOne = criteriaOne;
        this.criteriaTwo = criteriaTwo;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> personListOne = criteriaOne.meetCriteria(persons);
        List<Person> personListTwo = criteriaTwo.meetCriteria(persons);
        List<Person> personOneOrTwoList = new ArrayList<>();
        return Stream.concat(personListOne.stream(),personListTwo.stream()).distinct().collect(Collectors.toList());
    }
}
