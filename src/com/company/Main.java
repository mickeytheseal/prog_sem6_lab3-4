package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Enrollee e1 = new Enrollee("Alex",18,250,"4514 563221");
        Major[] budget_majors = e1.getBudgetMajors();
        Major[] majors = Major.values();
        System.out.println("Majors: " + Arrays.toString(majors));
        System.out.println("Available budget majors: " + Arrays.toString(budget_majors));
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick major [0-"+(majors.length-1)+"]");
        int mjr_num = sc.nextInt();
        e1.setMajor(majors[mjr_num]);
        System.out.println("You picked " + e1.getMajor().name());
        if(e1.getMajor().getScore() > e1.score){
            System.out.println("You score isn't enough for budget. You have to sign a contract.");
            Extrabudgetary ex1 = new Extrabudgetary(e1);
        }
        else{
            System.out.println("You've entered budgetary " + e1.getMajor().name());
            Budgetary b1 = new Budgetary(e1);
        }
        Student s1 = new Student(e1);
        System.out.println("Your student id: " + s1.getStud_id());

        Extrabudgetary ex1 = new Extrabudgetary(s1);
        ex1.extendContract();
        ex1.extendContract();
        ex1.setPaid();
        ex1.extendContract();

        //Перевод на бюджет
        Student b1 = new Budgetary(s1);

        System.out.println(ex1.getContract());
    }
}
