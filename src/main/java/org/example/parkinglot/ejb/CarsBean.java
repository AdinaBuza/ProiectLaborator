package org.example.parkinglot.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.EJBException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkinglot.common.CarDto;
import org.example.parkinglot.entities.Car;

import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars() {
        LOG.info("findAllCars");

        try {
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();

        for (Car car : cars) {
            CarDto dto = new CarDto(
                    car.getOwner().getUsername(),
                    car.getLicensePlate(),
                    car.getId(),
                    car.getParkingSpot()
            );
            carDtos.add(dto);
        }

        return carDtos;
    }


    public int getNumberOfFreeParkingSpots() {
        return 42;
    }
}