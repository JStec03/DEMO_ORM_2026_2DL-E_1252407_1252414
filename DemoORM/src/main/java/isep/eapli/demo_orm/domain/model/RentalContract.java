package isep.eapli.demo_orm.domain.model;
import isep.eapli.demo_orm.util.DateTime;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class RentalContract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rental_contract_id")
    private List<AuthorizedDriver> authorizedDrivers = new java.util.ArrayList<>();

    private LocalDate startDate;
    private LocalDate endDate;

    protected RentalContract() {}
    public RentalContract(Client client, Car car, LocalDate startDate, LocalDate endDate, Payment payment) {
        this.payment = payment;
        this.client = client;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void addAuthorizedDriver(AuthorizedDriver driver) {
        authorizedDrivers.add(driver);
    }

    @Override
    public String toString() {
        return String.format("RentalContract[id=%d, client='%s']", id, client);
    }
}
