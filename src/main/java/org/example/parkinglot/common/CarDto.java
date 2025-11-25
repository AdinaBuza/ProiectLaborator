package org.example.parkinglot.common;

public class CarDto {
    Long id;
    String licensePlate;
    String parkingSpot;
    String ownerName;

    public CarDto(String ownerName, String licensePlate, Long id, String parkingSpot) {
        this.ownerName = ownerName;
        this.licensePlate = licensePlate;
        this.id = id;
        this.parkingSpot = parkingSpot;
    }

    public Long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public String getOwnerName() {
        return ownerName;
    }
}