package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Enrollee e1 = new Enrollee("Alex",18,250,"4514 563221");
        Major[] budget_majors = e1.getBudgetMajors();
        System.out.println(Arrays.toString(budget_majors));
        e1.setMajor(budget_majors[1]);
        System.out.println(e1.getMajor().name());
    }
}
