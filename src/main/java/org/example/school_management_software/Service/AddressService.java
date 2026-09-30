package org.example.school_management_software.Service;

import org.example.school_management_software.Api.ApiException;
import org.example.school_management_software.DTO.AddressDTO;
import org.example.school_management_software.Model.Address;
import org.example.school_management_software.Model.Teacher;
import org.example.school_management_software.Repository.AddressRepository;
import org.example.school_management_software.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    // Get all addresses
    public List<Address> getAddresses() {

        return addressRepository.findAll();
    }


    // Get address by ID
    public Address getAddress(Integer id) {

        Address address = addressRepository.findAddressById(id);

        if (address == null) {
            throw new ApiException("Address not found");
        }

        return address;
    }


    // Add address to teacher
    public void addAddress(Integer teacherId, AddressDTO addressDTO) {

        Teacher teacher = teacherRepository.findTeacherById(teacherId);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        if (teacher.getAddress() != null) {
            throw new ApiException("Teacher already has an address");
        }

        Address address = new Address(
                null,
                addressDTO.getArea(),
                addressDTO.getStreet(),
                addressDTO.getBuildingNumber(),
                teacher
        );

        addressRepository.save(address);
    }


    // Update address
    public void updateAddress(Integer id, AddressDTO addressDTO) {

        Address address = addressRepository.findAddressById(id);

        if (address == null) {
            throw new ApiException("Address not found");
        }

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }


    // Delete address
    public void deleteAddress(Integer id) {

        Address address = addressRepository.findAddressById(id);

        if (address == null) {
            throw new ApiException("Address not found");
        }

        Teacher teacher = address.getTeacher();

        teacher.setAddress(null);

        addressRepository.delete(address);
    }
}