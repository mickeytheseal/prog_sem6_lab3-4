package com.company;


import java.util.Arrays;
import java.util.Calendar;

public abstract class Student extends Enrollee{
    private static int code = 100;
    protected final String stud_id;
    private int[][] marks; //для лабы 4

    public Student(Enrollee enrollee){
        super(enrollee.name, enrollee.age, enrollee.score, enrollee.id);
        super.major = enrollee.major;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        stud_id = String.valueOf(year).substring(2) + major.name().substring(0,2) + String.valueOf(code);
        code++;
        marks = new int[8][6]; //[семестр][предмет]
    }

    public Student(Student student){
        super(student.name, student.age, student.score, student.id);
        super.major = student.major;
        stud_id = student.stud_id;

        marks = new int[8][6]; //[семестр][предмет]
    }

    public String getStud_id(){ return stud_id; }

    // TODO: 26.03.2021 придумать нормальный нейминг и поставить ограничение на оцеки
    public void setMarks(int sem, int predm, int value){
        marks[sem][predm] = value;
    }

    public String getMarks(){
        return Arrays.deepToString(marks);
    }

}
