package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CLIENT_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String phone;

    protected Client() {}

    public Client(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public String getPhone() {
        return phone;
    }


    @Override
    public abstract  String toString();

}
