package com.springcore.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Coach {
    @Autowired
    @Qualifier("cricket")
    private Sport sport;

    public Coach() {
    }

    public Coach(Sport sport) {
        this.sport = sport;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }


}
