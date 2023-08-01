package com.soni.rolebaselogin.exception;

public class ScheduleNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 2L;

    public ScheduleNotFoundException(String message){
        super(message);
    }
}