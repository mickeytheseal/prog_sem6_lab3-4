package com.company;

import java.util.Date;
import java.util.Objects;

public class Mark {
    private final int value;
    private final int term;
    private final Subject subject;
    private final Date date;

    public Mark(int value,int term,Subject subject){
        this.value = value;
        this.term = term;
        this.subject = subject;
        date = new Date();
    }

    @Override
    public String toString() {
        return "Mark{" +
                "value=" + value +
                ", term=" + term +
                ", subject=" + subject +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return term == mark.term && subject == mark.subject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(term, subject);
    }
}
