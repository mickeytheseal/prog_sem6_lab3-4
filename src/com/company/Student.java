package com.company;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class Student extends Enrollee{
    private static int code = 100;
    protected final String stud_id;
    private ArrayList<Mark> marks;

    public Student(Enrollee enrollee){
        super(enrollee.name, enrollee.age, enrollee.score, enrollee.id);
        super.major = enrollee.major;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        stud_id = String.valueOf(year).substring(2) + major.name().substring(0,2) + String.valueOf(code);
        code++;
        marks = new ArrayList<>();
    }

    public Student(Student student){
        super(student.name, student.age, student.score, student.id);
        super.major = student.major;
        stud_id = student.stud_id;
    }

    public String getStud_id(){ return stud_id; }


    public void setMark(int value, int term, Subject subject){
        Mark new_mark = new Mark(value,term,subject);
        Stream<Mark> stream = marks.stream();
        stream.filter(mark -> mark.equals(new_mark)).findAny().ifPresent(to_change -> marks.remove(to_change));
        marks.add(new_mark);
    }

    public ArrayList<Mark> getMarks(){
        return marks;
    }
}
