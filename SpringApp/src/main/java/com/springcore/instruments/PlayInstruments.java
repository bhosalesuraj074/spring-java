package com.springcore.instruments;

public class PlayInstruments {
    public PlayInstruments(Instrument instrument) {
        this.instrument = instrument;
    }

    private Instrument instrument;


    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
