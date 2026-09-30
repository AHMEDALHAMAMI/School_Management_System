package org.example.school_management_software.Controller;

import org.example.school_management_software.Api.ApiResponse;
import org.example.school_management_software.DTO.AddressDTO;
import org.example.school_management_software.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/address")
public class AddressController {

    private final AddressService addressService;


    // Get all addresses
    @GetMapping("/get")
    public ResponseEntity<?> getAddresses() {

        return ResponseEntity.status(200).body(addressService.getAddresses()
        );
    }


    // Get address by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAddress(@PathVariable Integer id) {

        return ResponseEntity.status(200).body(addressService.getAddress(id)
        );
    }


    // Add teacher address
    @PostMapping("/add/{teacherId}")
    public ResponseEntity<?> addAddress(@PathVariable Integer teacherId, @Valid @RequestBody AddressDTO addressDTO) {

        addressService.addAddress(teacherId, addressDTO);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher address added successfully")
        );
    }


    // Update teacher address
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Integer id, @Valid @RequestBody AddressDTO addressDTO) {

        addressService.updateAddress(id, addressDTO);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher address updated successfully")
        );
    }


    // Delete teacher address
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {

        addressService.deleteAddress(id);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher address deleted successfully")
        );
    }
}