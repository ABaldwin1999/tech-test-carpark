package org.example;

public class Vehicle {
    private int Id =0;
    private VehicleType type;

    public Vehicle( ) {
        generateId();
    }

    public int getId() {
        return Id;
    }

    public VehicleType getType() {
        return type;
    }

    public int generateId() {
        this.Id =Id++;
        return Id;
    }
}