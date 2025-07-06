package com.springcore.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;


@Component()
public class Drive {

    @Autowired
    @VehicleName("car")
    private Vehicle vehicle;


    public void setVehicle( Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public  void start(){
        vehicle.drive();
    }



}
