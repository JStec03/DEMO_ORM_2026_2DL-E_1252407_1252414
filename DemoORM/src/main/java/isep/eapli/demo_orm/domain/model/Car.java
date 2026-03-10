package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String licensePlate;
    private String color;
    protected Car() {}
    public Car(String brand, String model, String licensePlate, String color) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Car[id=%d, brand='%s', model='%s', licensePlate='%s', color='%s']", id, brand, model, licensePlate, color);
    }
}
