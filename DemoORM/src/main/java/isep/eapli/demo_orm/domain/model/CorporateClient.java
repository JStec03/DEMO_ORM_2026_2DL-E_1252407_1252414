package isep.eapli.demo_orm.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CORPORATE")
public class CorporateClient extends Client {
    private String companyName;
    private String vatNumber;
    private String address;

    protected CorporateClient() {}

    public CorporateClient(String email, String phone, String companyName, String vatNumber, String address) {
        super(email, phone);
        this.companyName = companyName;
        this.vatNumber = vatNumber;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("CorporateClient[id=%d, email='%s', phone='%s', companyName='%s', vatNumber='%s', address='%s']",
                getId(), getEmail(), getPhone(), companyName, vatNumber, address);
    }
}
