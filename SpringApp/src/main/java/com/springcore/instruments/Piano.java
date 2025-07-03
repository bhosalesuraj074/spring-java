package com.springcore.instruments;

public class Piano implements Instrument {
    private String piano;

    public String getPiano() {
        return piano;
    }

    public void setPiano(String piano) {
        this.piano = piano;
    }

    @Override
    public void play() {
        System.out.println("Playing "+ piano +".......");
    }
}
