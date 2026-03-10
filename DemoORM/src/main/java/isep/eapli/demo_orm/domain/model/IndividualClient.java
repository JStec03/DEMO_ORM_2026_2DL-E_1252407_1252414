package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INDIVIDUAL")
public class IndividualClient  extends  Client {
    private String name;
    private String phone;
    private String nif;
    private String address;
    protected IndividualClient() {}
    public IndividualClient(String email, String phone, String name, String nif, String address) {
        super(email, phone);
        this.name = name;
        this.nif = nif;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getNif() {
        return nif;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return String.format("IndividualClient[id=%d, email='%s', phone='%s', name='%s', nif='%s', address='%s']",
                getId(), getEmail(), getPhone(), name, nif, address);
    }

}
