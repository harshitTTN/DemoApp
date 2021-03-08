package com.mysite.core.services;

public class Student {
    private int id;
    private String name;
    private int marksObtained;

    public Student(int id, String name, int marksObtained){
        this.id = id;
        this.name = name;
        this.marksObtained = marksObtained;
    }

    public String toString(){
        return "Name :" +name + "Id:" + id + "Marks"+marksObtained;
    }

    public int getId(){
        return id;
    }

    public int getMarks(){
        return marksObtained;
    }


}
