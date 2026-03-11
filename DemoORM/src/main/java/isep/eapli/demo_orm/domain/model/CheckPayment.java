package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class CheckPayment extends Payment {

    private String checkNumber;

    protected CheckPayment() {
        // for ORM
    }

    public CheckPayment(double amount, LocalDate date, String checkNumber) {
        super(amount, date);
        this.checkNumber = checkNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "CheckPayment[id=%d, amount=%.2f, date=%s, checkNumber='%s']",
                getId(), getAmount(), getDate(), checkNumber
        );
    }
}