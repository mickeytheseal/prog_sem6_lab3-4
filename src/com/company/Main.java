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

        Extrabudgetary ex1 = null;
        Budgetary b1 = null;
        if(e1.getMajor().getScore() > e1.score){
            System.out.println("You score isn't enough for budget. You have to sign a contract.");
            ex1 = new Extrabudgetary(e1);
            System.out.println(ex1.getStud_id());
        }
        else{
            System.out.println("You've entered budgetary " + e1.getMajor().name());
            b1 = new Budgetary(e1);
            System.out.println(b1.getStud_id());
        }

        ex1.extendContract();
        ex1.extendContract();
        ex1.setPaid();
        ex1.extendContract();
        System.out.println(ex1.getStud_id());

        //Перевод на бюджет
        b1 = new Budgetary(ex1);
        System.out.println("Student is budgetary now.");
        System.out.println(b1.getStud_id());

        Extrabudgetary ex2 = new Extrabudgetary(e1);
        System.out.println(ex2.getStud_id());
        Budgetary b2 = new Budgetary(ex2);
        System.out.println(b2.getStud_id());
    }
}
