package com.jatin.designpatterns.criteriadesingpattern;

import java.util.List;

public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
