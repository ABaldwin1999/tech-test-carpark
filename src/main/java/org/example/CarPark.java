package org.example;

import java.util.ArrayList;
import java.util.Random;

import static org.example.VehicleType.*;

public class CarPark {
    private ArrayList<Space> spaces;

    public CarPark(ArrayList<Space> spaces) {
        this.spaces = spaces;
    }

    public void unParkVehicle(Vehicle vehicle){
        for (Space space:spaces) {
           if( space.getVehicleId()== vehicle.getId()){
               space.setOccupied(false);
               space.setVehicleId(0);
           }
        }
    }
    public void parkVehicle(Vehicle vehicle){
        if (vehicle.getType() == MOTORCYCLE) {
            for (Space space : spaces) {
                if (!space.isOccupied()) {
                    space.setOccupied(true);
                    space.setOccupiedBy(MOTORCYCLE);
                    space.setVehicleId(vehicle.getId());
                }
            }
        } else if (vehicle.getType() == CAR) {
            for (Space space : spaces) {
                if ((space.getType() == SpaceType.MEDIUM || space.getType() == SpaceType.LARGE) && !space.isOccupied()) {
                    space.setOccupied(true);
                    space.setOccupiedBy(CAR);
                    space.setVehicleId(vehicle.getId());
                }
            }
        }
        else{
            for (int i = 0; i < spaces.size(); i++) {
                if (spaces.get(i).getType()==SpaceType.LARGE&& spaces.get(i+1).getType()==SpaceType.LARGE&&
                        spaces.get(i+2).getType()==SpaceType.LARGE&&!spaces.get(i).isOccupied()
                &&!spaces.get(i+1).isOccupied()&&!spaces.get(i+2).isOccupied()) {
                    for (int j = 0; j < 3; j++) {
                        spaces.get(i+j).setOccupied(true);
                        spaces.get(i+j).setOccupiedBy(VAN);
                        spaces.get(i).setVehicleId(vehicle.getId());
                    }
                }
            }
        }
    }

    public int findRemainingSpaces(){
        int freeSpaces =0;
        for (Space space : spaces) {
            if (!space.isOccupied()) {
                freeSpaces++;
            }
        }
        return freeSpaces;
        }
    public int getCarParkSize(){
        return spaces.size();
    }
    public boolean parkingLotEmpty(){
        if(findRemainingSpaces()==0){
            return true;
        }
        return false;
    }
    public void populateCarPark(int size){
        Random RANDOM = new Random();
        for (int i = 0; i < size; i++) {
            switch (RANDOM.nextInt(3)) {
                case 0:
                    Space space = new Space(true, SpaceType.SMALL, NONE);
                    spaces.add(space);
                    break;
                case 1:
                    Space space0 = new Space(true, SpaceType.SMALL, NONE);
                    spaces.add(space0);
                case 2:
                    if(39-i>=3){
                        Space space1 = new Space(true, SpaceType.LARGE, NONE);
                        spaces.add(space1);
                        spaces.add(space1);
                        spaces.add(space1);
                        i+=2;
                    }
                    else{
                        Space space2 = new Space(true, SpaceType.MEDIUM, NONE);
                        spaces.add(space2);
                    }
            }
        }
    }
}