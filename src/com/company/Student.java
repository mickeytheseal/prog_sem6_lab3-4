package com.company;


import java.util.Calendar;

public class Student extends Enrollee{
    private static int code = 100;
    private final String stud_id;
    private int[][] marks;

    public Student(Enrollee enrollee){
        super(enrollee.name, enrollee.age, enrollee.score, enrollee.id);
        super.major = enrollee.major;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        stud_id = String.valueOf(year).substring(2) + major.name().substring(0,2) + String.valueOf(code);
        code++;
    }

    public String getStud_id(){ return stud_id; }
}
