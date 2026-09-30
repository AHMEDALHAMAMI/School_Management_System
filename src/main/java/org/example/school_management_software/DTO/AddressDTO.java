package org.example.school_management_software.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotBlank(message = "Area is required")
    private String area;

    @NotBlank(message = "Street is required")
    private String street;

    @NotNull(message = "Building number is required")
    @Positive(message = "Building number must be greater than 0")
    private Integer buildingNumber;
}