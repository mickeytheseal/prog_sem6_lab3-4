package com.company;

import java.util.Calendar;
import java.util.Date;

public class Budgetary extends Student{
    private String bank_account;
    private static final int scholarship = 5000;

    public Budgetary(Enrollee enrollee) {
        super(enrollee);
    }
    public Budgetary(Student student) {
        super(student);
    }

    public void sendScholarship(){
        System.out.println("Scholarship sent");
    }
}
