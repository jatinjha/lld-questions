package com.jatin.designpatterns.builderpattern;

import java.util.List;

public abstract class StudentBuilder {
    int rollNumber;
    String name;
    List<String> subjects;

    public StudentBuilder setName(String name){
        this.name = name;
        return this;
    }

    public StudentBuilder setRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
        return this;
    }

    public abstract StudentBuilder setSubjects();

    public Student build(){
        return new Student(this);
    }

}
