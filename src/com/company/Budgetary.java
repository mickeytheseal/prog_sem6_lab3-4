package com.company;

public class Budgetary extends Student{
    private String bank_account;
    private static final int scholarship = 5000;

    public Budgetary(Enrollee enrollee) {
        super(enrollee);
    }
    public Budgetary(Extrabudgetary extrabudgetary) {
        super(extrabudgetary);
    }

    public void sendScholarship(){
        System.out.println("Scholarship sent");
    }
}
