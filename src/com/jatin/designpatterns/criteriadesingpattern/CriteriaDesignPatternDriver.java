package com.jatin.designpatterns.criteriadesingpattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaDesignPatternDriver {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        Person person1 = new Person("a", "male", "single");
        Person person2 = new Person("b", "female", "married");
        Person person3 = new Person("c", "female", "single");
        Person person4 = new Person("d", "male", "married");
        Person person5 = new Person("e", "male", "married");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        Criteria maleORMarried = new OrCriteria(new MaleCriteria(), new MarriedCriteria());
        List<Person> maleOrMarriedPersons = maleORMarried.meetCriteria(personList);

        maleOrMarriedPersons.forEach(System.out::println);
    }

}
