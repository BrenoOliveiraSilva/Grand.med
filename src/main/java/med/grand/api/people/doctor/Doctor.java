package med.grand.api.people.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.grand.api.address.Address;

@Table(name = "doctors")
@Entity(name = "Doctor")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean active;
    private String name;
    private String email;
    private String phoneNumber;
    private String licenseNumber;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;

    public Doctor(DoctorRegistrationData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phoneNumber = data.phoneNumber();
        this.licenseNumber = data.licenseNumber();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void updateData(DoctorUpdateData data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.phoneNumber() != null) {
            this.phoneNumber = data.phoneNumber();
        }
        if (data.address() != null) {
            this.address.updateData(data.address());
        }
    }

    public void disable() {
        this.active = false;
    }
}

