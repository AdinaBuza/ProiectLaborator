package org.example.parkinglot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 3, max = 100)
    @Column(name = "license_plate", unique = true, nullable = false, length = 100)
    private String licensePlate;

    @Size(min = 3, max = 100)
    @Column(name = "parking_spot", unique = true, nullable = false, length = 100)
    private String parkingSpot;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CarPhoto photo;

    // ... Păstrează Getters și Setters existenți ...
    // (Include getPhoto, setPhoto, getOwner, setOwner etc.)

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public String getParkingSpot() { return parkingSpot; }
    public void setParkingSpot(String parkingSpot) { this.parkingSpot = parkingSpot; }
    public CarPhoto getPhoto() { return photo; }
    public void setPhoto(CarPhoto photo) { this.photo = photo; }
}