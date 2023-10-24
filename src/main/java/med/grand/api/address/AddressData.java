package med.grand.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank
        String state,
        @NotBlank
        String city,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String postalCode,
        @NotBlank
        String neighborhood,
        @NotBlank
        String street,
        String number,
        String complement
) {
}
