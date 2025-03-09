package com.jatin.designpatterns.builderpattern;

public class BuilderClient {
    public static void main(String[] args) {
        Director director = new Director(new MBAStudent());
        Student student = director.createStudent();
        System.out.println(student.toString());
    }
}
