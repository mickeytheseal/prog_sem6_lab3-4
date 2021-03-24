package com.company;

public enum Major {
    CYB(260),   //Cybernetics
    PROG(240),  //Programming
    MATH(220),  //Math
    PHYS(170),  //Physics
    DES(210),   //Design
    PR(270);    //Public relations

    private int score;

    Major(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }
}
