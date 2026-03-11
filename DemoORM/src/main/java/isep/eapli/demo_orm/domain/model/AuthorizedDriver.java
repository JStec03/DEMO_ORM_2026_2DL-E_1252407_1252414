package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.*;

@Entity
public class AuthorizedDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String drivingLicenseNumber;
    private String name;

    protected AuthorizedDriver() {}
    public AuthorizedDriver(String drivingLicenseNumber, String name) {
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return String.format("AuthorizedDriver[id=%d, name='%s', drivingLicenseNumber='%s']", id, name, drivingLicenseNumber);
    }

}
