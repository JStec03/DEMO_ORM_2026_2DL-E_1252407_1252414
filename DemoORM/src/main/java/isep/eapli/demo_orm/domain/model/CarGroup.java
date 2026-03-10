package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;


@Entity
public class CarGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int doors;
    private String carClass;

    protected CarGroup() {}

    public  CarGroup(String name, int doors, String carClass) {
        this.name = name;
        this.doors = doors;
        this.carClass = carClass;
    }

    @Override
    public String toString() {
        return String.format("CarGroup[id=%d, name='%s', doors=%d, class='%s']", id, name, doors, carClass);
    }
}
