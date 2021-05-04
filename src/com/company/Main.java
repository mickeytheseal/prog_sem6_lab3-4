package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Enrollee e1 = new Enrollee("Alex",18,250,"4514563221");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name, age, score and id without any other characters");
        String name = sc.next();
        int age = sc.nextInt();
        int score = sc.nextInt();
        String id = sc.next();

        Enrollee e1 = new Enrollee(name,age,score,id);
        System.out.println("New enrollee. " + e1.getInfo());

        Major[] budget_majors = e1.getBudgetMajors();
        Major[] majors = Major.values();
        System.out.println("Majors: " + Arrays.toString(majors));
        System.out.println("Available budget majors: " + Arrays.toString(budget_majors));
        System.out.println("Pick major [0-"+(majors.length-1)+"]");
        int mjr_num = sc.nextInt();
        e1.setMajor(majors[mjr_num]);
        System.out.println("You picked " + e1.getMajor().name());

        Extrabudgetary ex1 = null;
        Budgetary b1 = null;
        if(e1.getMajor().getScore() > e1.score){
            System.out.println("Your score isn't enough for budget. You have to sign a contract.");
            ex1 = new Extrabudgetary(e1);
            System.out.println("Contract №"+ex1.getContract()+" was signed. Your student ID is "+ex1.getStud_id());
        }
        else{
            System.out.println("You've entered budgetary " + e1.getMajor().name());
            b1 = new Budgetary(e1);
            System.out.println(b1.getStud_id());
        }

        //Для тестирования в случае поступления на внебюджет
        ex1.extendContract();
        ex1.extendContract();
        ex1.setPaid();
        ex1.extendContract();
        System.out.println("Extrabudgetary student "+ex1.name+". ID: "+ex1.getStud_id());

        //Перевод на бюджет
        b1 = new Budgetary(ex1);
        System.out.println("Student is budgetary now.");
        System.out.println("Budgetary student "+b1.name+". ID: "+b1.getStud_id());

    }
}
