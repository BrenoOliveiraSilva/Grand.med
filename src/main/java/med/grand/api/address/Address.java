package med.grand.api.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Address {
    private String state;
    private String city;
    private String postalCode;
    private String neighborhood;
    private String street;
    private String number;
    private String complement;

    public Address(AddressData data) {
        this.state = data.state();
        this.city = data.city();
        this.postalCode = data.postalCode();
        this.neighborhood = data.neighborhood();
        this.street = data.street();
        this.number = data.number();
        this.complement = data.complement();
    }

    public void updateData(AddressData data) {
        if (data.state() != null) {
            this.state = data.state();
        }
        if (data.city() != null) {
            this.city = data.city();
        }
        if (data.postalCode() != null) {
            this.postalCode = data.postalCode();
        }
        if (data.neighborhood() != null) {
            this.neighborhood = data.neighborhood();
        }
        if (data.street() != null) {
            this.street = data.street();
        }
        if (data.number() != null) {
            this.number = data.number();
        }
        if (data.complement() != null) {
            this.complement = data.complement();
        }
    }
}
