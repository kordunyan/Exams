package com.exams.entity.comparator;

import com.exams.entity.Exam;
import java.util.Comparator;

public class ExamComparator implements Comparator<Exam>{

    private boolean orderType;

    public ExamComparator(boolean orderType){
        this.orderType = orderType;
    }

    @Override
    public int compare(Exam o1, Exam o2) {
        if(orderType) return o1.getCreateDate().compareTo(o2.getCreateDate());
        return o2.getCreateDate().compareTo(o1.getCreateDate());
    }
}
