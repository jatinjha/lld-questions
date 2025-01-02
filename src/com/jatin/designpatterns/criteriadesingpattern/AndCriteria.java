package com.jatin.designpatterns.criteriadesingpattern;

import java.util.List;

public class AndCriteria implements Criteria{
    private final Criteria criteriaOne;
    private final Criteria criteriaTwo;

    public AndCriteria(Criteria criteriaOne , Criteria criteriaTwo){
        this.criteriaOne = criteriaOne;
        this.criteriaTwo = criteriaTwo;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> criteriaOneList = criteriaOne.meetCriteria(persons);
        return criteriaTwo.meetCriteria(criteriaOneList);
    }
}
