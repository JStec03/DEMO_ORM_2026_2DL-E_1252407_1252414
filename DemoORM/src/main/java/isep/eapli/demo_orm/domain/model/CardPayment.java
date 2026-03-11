package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class CardPayment extends Payment {

    private String cardNumber;

    protected CardPayment() {
        // for ORM
    }

    public CardPayment(double amount, LocalDate date, String cardNumber) {
        super(amount, date);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "CardPayment[id=%d, amount=%.2f, date=%s, cardNumber='%s']",
                getId(), getAmount(), getDate(), cardNumber
        );
    }
}