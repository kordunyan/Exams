package com.exams.service.impl;

import com.exams.service.PaginationService;

public class PaginationServiceImpl implements PaginationService {

    private int showPages;
    private int interval;
    private int countPages;
    private int current;
    private int start;
    private int end;


    public PaginationServiceImpl(int showPages, int countPages, int current){
        interval = showPages/2;
        if(countPages <= showPages){
            start = 1;
            end = countPages;
        }
        else{

            if(current <= interval+1){
                start = 1;
                end = showPages;
            }
            else{
                if(current+interval >  countPages){
                    start = countPages - showPages;
                    end = countPages;
                }
                else{
                    start = current-interval;
                    end = current+interval;
                }
            }
        }
    }

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public int getEnd() {
        return end;
    }
}
