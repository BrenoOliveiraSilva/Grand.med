package med.grand.api.people.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.grand.api.address.AddressData;

public record DoctorRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phoneNumber,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String licenseNumber,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        AddressData address
) {
}
