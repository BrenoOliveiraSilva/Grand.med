package med.grand.api.people.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.grand.api.address.AddressData;

public record PatientRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phoneNumber,
        @NotNull
        @Valid
        AddressData address
) {
}
