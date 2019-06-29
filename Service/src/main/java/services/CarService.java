package services;

import entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CarRepository;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


    public Optional<Car> loadCarById(long id) {
        return carRepository.findById(id);
    }

}
