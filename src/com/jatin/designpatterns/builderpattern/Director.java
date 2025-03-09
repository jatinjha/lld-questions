package com.jatin.designpatterns.builderpattern;

public class Director {

    StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder){
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent(){

        if(studentBuilder instanceof MBAStudent){
            return createMBAStudent();
        }
        return null;
    }


    private Student createMBAStudent(){
        return studentBuilder.setRollNumber(2).setName("sj").setSubjects().build();
    }
}


