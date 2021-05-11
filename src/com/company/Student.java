package com.company;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class Student extends Enrollee{
    private static int code = 100;
    protected final String stud_id;
    private static int term;
    private ArrayList<Mark> marks;
    private ArrayList<Mark> failed;

    public Student(Enrollee enrollee){
        super(enrollee.name, enrollee.age, enrollee.score, enrollee.id);
        super.major = enrollee.major;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        stud_id = String.valueOf(year).substring(2) + major.name().substring(0,2) + String.valueOf(code);
        code++;
        term = 1;
        marks = new ArrayList<>();
        failed = new ArrayList<>();
    }

    public Student(Student student){
        super(student.name, student.age, student.score, student.id);
        super.major = student.major;
        stud_id = student.stud_id;
    }

    public String getStud_id(){ return stud_id; }

    public void upperTransfer(){
        if (term % 2 != 0){
            System.out.println("It is not the end of the course");
        }else if (failed.size() <= 3){
            term++;
        }else{
            System.out.println("Student have " + failed.size() + " failed exams.");
        }
    }

    public int getTerm(){ return term; }
    public static void nextTerm(){ term++; }

    public void setMark(int value, int term, Subject subject){
        Mark new_mark = new Mark(value,term,subject);
        if (value <= 2){
            failed.add(new_mark);
        }else {
            Stream<Mark> failed_stream = failed.stream();
            failed_stream.filter(mark -> mark.equals(new_mark)).findAny().ifPresent(to_remove -> failed.remove(to_remove));
        }
        Stream<Mark> marks_stream = marks.stream();
        marks_stream.filter(mark -> mark.equals(new_mark)).findAny().ifPresent(to_change -> marks.remove(to_change));
        marks.add(new_mark);
    }

    public ArrayList<Mark> getMarks(){ return marks; }

    public ArrayList<Mark> getFailed(){ return failed; }

}
