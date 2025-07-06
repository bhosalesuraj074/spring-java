package com.springcore.sport;

public class BaseBall implements Sport{
    private String sportName;

    public BaseBall() {
    }

    public BaseBall(String sportName) {
        this.sportName = sportName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }


    @Override
    public void display() {
        System.out.println("Playing "+ this.getSportName()+".....");
    }
}
