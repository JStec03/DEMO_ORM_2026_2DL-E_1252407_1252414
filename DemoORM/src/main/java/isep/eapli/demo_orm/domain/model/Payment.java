package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;
    private LocalDate date;

    protected Payment() {
        // for ORM
    }

    protected Payment(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}