package com.jatin.designpatterns.builderpattern;

import java.util.ArrayList;
import java.util.List;

/*
concrete builder
 */
public class MBAStudent extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Mathss");
        subjects.add("finance");
        subjects.add("accounts");
        this.subjects = subjects;
        return this;
    }
}
