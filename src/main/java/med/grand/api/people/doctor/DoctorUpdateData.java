package med.grand.api.people.doctor;

import jakarta.validation.constraints.NotNull;
import med.grand.api.address.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String name,
        String phoneNumber,
        AddressData address
) {
}
