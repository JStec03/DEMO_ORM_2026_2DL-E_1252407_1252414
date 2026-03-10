package isep.eapli.demo_orm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;


@Entity
public class CarGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int doors;
    private String carClass;
    public  CarGroup() {}
    public CarGroup(String nome, int portas, String classe) {}
}
