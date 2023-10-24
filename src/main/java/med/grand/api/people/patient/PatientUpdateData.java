package med.grand.api.people.patient;

import jakarta.validation.constraints.NotNull;
import med.grand.api.address.AddressData;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name,
        String phoneNumber,
        AddressData address
) {
}