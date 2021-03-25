package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Enrollee e1 = new Enrollee("Alex",18,250,"4514 563221");
        Major[] budget_majors = e1.getBudgetMajors();
        Major[] majors = Major.values();
        System.out.println("Majors: " + Arrays.toString(majors));
        System.out.println("Available budget majors: " + Arrays.toString(budget_majors));
        e1.setMajor(majors[1]);
        System.out.println("You picked " + e1.getMajor().name());
        Student s1 = new Student(e1);
        System.out.println(s1.getStud_id());
    }
}
