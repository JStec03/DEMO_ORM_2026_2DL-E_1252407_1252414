package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.*;
import isep.eapli.demo_orm.domain.model.CarGroup;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "car_group_id")
    private  CarGroup carGroup;


    private String brand;
    private String model;
    private String licensePlate;
    private String color;



    protected Car() {}
    public Car(String brand, String model, String licensePlate, String color, CarGroup carGroup) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.color = color;
        this.carGroup = carGroup;
    }

    @Override
    public String toString() {
        return String.format("Car[id=%d, brand='%s', model='%s', licensePlate='%s', color='%s', group_id='%s']", id, brand, model, licensePlate, color, carGroup != null ? carGroup.getId() : "null");
    }
}
