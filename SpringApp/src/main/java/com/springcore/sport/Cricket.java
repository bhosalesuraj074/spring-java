package com.springcore.sport;

public class Cricket implements Sport{
    private String sportName;

    public Cricket() {
    }

    public Cricket(String sportName) {
        this.sportName = sportName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }


    public void display() {
        System.out.println("Playing "+ this.getSportName()+".....");
    }
}
