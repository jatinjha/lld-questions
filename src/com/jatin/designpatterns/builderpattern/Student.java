package com.jatin.designpatterns.builderpattern;

import java.util.List;

public class Student {
    int rollNumber;
    String name;
    List<String> subjects;

    public Student(StudentBuilder studentBuilder){
        this.rollNumber = studentBuilder.rollNumber;
        this.name = studentBuilder.name;
        this.subjects = studentBuilder.subjects;
    }

    public String toString(){
        return ""+ " roll number: " + this.rollNumber +
                " name: " + this.name +
                " subjects: " + subjects.get(0) + "," + subjects.get(1) + "," + subjects.get(2);
    }


}
