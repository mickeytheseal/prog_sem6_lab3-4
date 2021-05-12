package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static ArrayList<Student> students;

    public static void main(String[] args) {
        students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean to_stop = false;
        while (!to_stop){
            System.out.println("\nCommands: 1 - add student; 2 - getInfo; 3 - transferToBudget;4 - setMark;\n" +
                    "5 - printMarks; 6 - printFailed; 7 - nextTerm; 8 - upperTransfer; 9-setPaid; 0 - exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> printInfo();
                case 3 -> transferToBudget();
                case 4 -> setMark();
                case 5 -> printMarks();
                case 6 -> printFailed();
                case 7 -> Student.nextTerm();
                case 8 -> upperTransfer();
                case 9 -> setPaid();
                case 0 -> to_stop = true;
                default -> System.out.println("Unexpected choice");
            }
        }
    }

    private static void addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name, age, score and id without any other characters");
        String name = sc.next();
        int age = sc.nextInt();
        int score = sc.nextInt();
        String id = sc.next();

        Enrollee enrollee = new Enrollee(name,age,score,id);
        System.out.println("New enrollee. " + enrollee.getInfo());

        Major[] budget_majors = enrollee.getBudgetMajors();
        Major[] majors = Major.values();
        System.out.println("Majors: " + Arrays.toString(majors));
        System.out.println("Available budget majors: " + Arrays.toString(budget_majors));
        System.out.println("Pick major [0-"+(majors.length-1)+"]");
        int mjr_num = sc.nextInt();
        enrollee.setMajor(majors[mjr_num]);
        System.out.println("You picked " + enrollee.getMajor().name());

        Extrabudgetary extrabudgetary = null;
        Budgetary budgetary = null;
        if(enrollee.getMajor().getScore() > enrollee.score){
            System.out.println("Your score isn't enough for budget. You have to sign a contract.");
            extrabudgetary = new Extrabudgetary(enrollee);
            System.out.println("Contract №"+extrabudgetary.getContract()+" was signed." +
                    " Your student ID is "+extrabudgetary.getStud_id());
            students.add(extrabudgetary);
        }
        else{
            System.out.println("You've entered budgetary " + enrollee.getMajor().name());
            budgetary = new Budgetary(enrollee);
            System.out.println("Your student ID is "+budgetary.getStud_id());
            students.add(budgetary);
        }
    }

    private static void printInfo(){
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println("Pick student [0-" + (students.size()-1) + "]");
        Scanner sc = new Scanner(System.in);
        System.out.println(students.get(sc.nextInt()).getInfo());
    }

    private static void transferToBudget(){
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println("Pick student [0-" + (students.size()-1) + "]");
        Scanner sc = new Scanner(System.in);
        int sdt_num = sc.nextInt();
        Budgetary budgetary = new Budgetary(students.get(sdt_num));
        System.out.println("Student is budgetary now.");
        System.out.println("Budgetary student "+budgetary.name+". ID: "+budgetary.getStud_id());
        students.remove(sdt_num);
        students.add(budgetary);
    }

    private static void setMark() {
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println("Pick student [0-" + (students.size()-1) + "]");
        Scanner sc = new Scanner(System.in);
        Student student = students.get(sc.nextInt());
        System.out.println("Enter value");
        int value = sc.nextInt();
        System.out.println("Enter custom term or type 0 to use current term");
        int term = sc.nextInt();
        if (term == 0){ term = student.getTerm(); }
        System.out.println(Arrays.toString(Subject.values()));
        System.out.println("Pick subject [0-" + (Subject.values().length-1)+"]");
        Subject subject = Subject.values()[sc.nextInt()];
        student.setMark(value,term,subject);
    }

    private static void printMarks(){
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println("Pick student [0-" + (students.size()-1) + "]");
        Scanner sc = new Scanner(System.in);
        System.out.println(Arrays.toString(students.get(sc.nextInt()).getMarks().toArray()));
    }

    private static void printFailed(){
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println("Pick student [0-" + (students.size()-1) + "]");
        Scanner sc = new Scanner(System.in);
        System.out.println(Arrays.toString(students.get(sc.nextInt()).getFailed().toArray()));
    }

    private static void upperTransfer(){
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println("Pick student [0-" + (students.size()-1) + "] or type -1 to transfer all students");
        Scanner sc = new Scanner(System.in);
        int std_num = sc.nextInt();
        if (std_num == -1){
            students.forEach(Student::upperTransfer);
        }else{
            students.get(std_num).upperTransfer();
        }
    }

    private static void setPaid(){
        System.out.println(Arrays.toString(students.toArray()));
        System.out.println("Pick student [0-" + (students.size()-1) + "]");
        Scanner sc = new Scanner(System.in);
        Extrabudgetary extrabudgetary = (Extrabudgetary)students.get(sc.nextInt());
        extrabudgetary.setPaid();
        System.out.println("Student " + extrabudgetary + " has paid");
    }
}
