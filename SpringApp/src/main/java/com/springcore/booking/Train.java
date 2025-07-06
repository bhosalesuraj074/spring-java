package com.springcore.booking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("train")
public class Train implements Notification{
    @Value("Train value")
    private String train;

    public Train() {
    }

    public Train(String train) {
        this.train = train;
    }


    @Override
    public void ConfirmTicket() {
        System.out.println("Train ticket confirmed...");
        System.out.println(train);
    }
}
