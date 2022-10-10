package org.example;

public class Space {
    private boolean occupied = false;
    private SpaceType type;
    private VehicleType occupiedBy;
    private int vehicleId;
    public Space(boolean occupied, SpaceType type, VehicleType occupiedBy) {
        this.occupied = occupied;
        this.type = type;
        this.occupiedBy = occupiedBy;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setOccupiedBy(VehicleType occupiedBy) {
        this.occupiedBy = occupiedBy;
    }

    public SpaceType getType() {
        return type;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
