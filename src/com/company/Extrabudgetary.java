package com.company;

import java.util.Calendar;
import java.util.Date;

public class Extrabudgetary extends Student{
    private final String contract;
    private Date expiration_date;
    private boolean is_paid;    //оплачен ли следующий семестр

    public Extrabudgetary(Enrollee enrolee) {
        super(enrolee);
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 4);
        expiration_date = c.getTime();
        is_paid = false;
        contract = String.valueOf(this.hashCode());
    }
    public Extrabudgetary(Student student) {
        super(student);
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 4);
        expiration_date = c.getTime();
        is_paid = false;
        contract = String.valueOf(this.hashCode());
    }

    public String getContract(){ return contract; }
    public boolean getIsPaid(){ return is_paid; }
    public void setPaid(){ is_paid = true; }

    @Override
    public void upperTransfer() {
        if (is_paid) {
            super.upperTransfer();
        } else {
            System.out.println("Student hasn't paid yet. Notification sent.");
        }
    }

    public void extendContract(){
        if (is_paid){
            Calendar c = Calendar.getInstance();
            c.setTime(expiration_date);
            c.add(Calendar.MONTH, 4);
            expiration_date = c.getTime();
            is_paid = false;
            System.out.println("Contract extended.");
        }
        else {
            System.out.println("Student hasn't paid yet. Notification sent.");
        }
    }

}
