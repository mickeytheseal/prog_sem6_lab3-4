package com.company;

import java.util.ArrayList;

public class Enrollee {
    protected String name;
    protected int age;
    protected int score;
    protected String id;
    protected Major major;

    public Enrollee(String name, int age, int score, String id){
        this.name = name;
        this.age = age;
        this.score = score;
        this.id = id;
    }

    public Major getMajor(){ return major; }
    public void setMajor(Major major){ this.major = major; }

    public Major[] getBudgetMajors(){
        ArrayList<Major> result_list = new ArrayList<>();
        for (Major elem: Major.values()) {
            if( score >= elem.getScore()){ result_list.add(elem); }
        }
        Major[] result = new Major[result_list.size()];
        result = result_list.toArray(result);
        return result;
    }

    public String getInfo(){
        return "Name:" + name + ", Age:" + age + ", Score:" + score + ", ID:" + id;
    }
}
