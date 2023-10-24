package med.grand.api.people.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.grand.api.address.Address;
import med.grand.api.people.doctor.DoctorUpdateData;

@Table(name = "patients")
@Entity(name = "Patient")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean active;
    private String name;
    private String email;
    private String phoneNumber;
    @Embedded
    private Address address;

    public Patient(PatientRegistrationData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phoneNumber = data.phoneNumber();
        this.address = new Address(data.address());
    }

    public void updateData(PatientUpdateData data) {
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