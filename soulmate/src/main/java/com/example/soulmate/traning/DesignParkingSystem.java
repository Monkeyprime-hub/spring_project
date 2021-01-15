package com.example.soulmate.traning;

public class DesignParkingSystem {

    /**
     * Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.
     * <p>
     * Implement the ParkingSystem class:
     * <p>
     * ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class. The number of slots for each parking space are given as part of the constructor.
     * <p>
     * bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get into the parking lot.
     * <p>
     * carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively.
     * <p>
     * A car can only park in a parking space of its carType. If there is no space available, return false, else park the car in that size space and return true.
     */

    private int big;
    private int mediun;
    private int small;

    public DesignParkingSystem(int big, int mediun, int small) {
        this.big = big;
        this.mediun = mediun;
        this.small = small;
    }

    public boolean addCar(int carType) {

        if (carType == 1) {
            big--;
            return big + 1 > 0;
        }
        if (carType == 2) {
            mediun--;
            return mediun + 1 > 0;
        }
        if (carType == 3) {
            small--;
            return small + 1 > 0;
        }

        return false;
    }

    public static void main(String[] args) {
        DesignParkingSystem obj = new DesignParkingSystem(1, 2, 3);
        System.out.println( obj.addCar(1));
        System.out.println( obj.addCar(1));

    }

    /**
     * Your ParkingSystem object will be instantiated and called as such:
     * ParkingSystem obj = new ParkingSystem(big, medium, small);
     * boolean param_1 = obj.addCar(carType);
     */

}
