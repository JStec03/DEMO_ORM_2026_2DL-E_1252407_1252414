package isep.eapli.demo_orm.domain.model;
import jakarta.persistence.*;

@Entity
public class RentalContract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    protected RentalContract() {}
    public RentalContract(Client client) {}

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return String.format("RentalContract[id=%d, client='%s']", id, client);
    }
}
