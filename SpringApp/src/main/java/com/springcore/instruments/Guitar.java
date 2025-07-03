package com.springcore.instruments;

public class Guitar implements Instrument{
    private String guitar;

    public String getGuitar() {
        return guitar;
    }

    public void setGuitar(String guitar) {
        this.guitar = guitar;
    }

    @Override

    public void play() {
        System.out.println("Playing " + this.guitar+"........");
    }
}
