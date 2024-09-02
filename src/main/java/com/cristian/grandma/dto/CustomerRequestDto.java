package com.cristian.grandma.dto;

import com.cristian.grandma.entity.Address;
import com.cristian.grandma.entity.Customer;
import com.cristian.grandma.entity.Document;
import com.cristian.grandma.entity.DocumentType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.stream.Collectors;

public record CustomerRequestDto(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Phone is required")
        @Size(min = 10, max = 11, message = "Phone must have 11 characters")
        String phone,

        @NotBlank(message = "Phone is required")
        @Email(message = "Invalid email")
        String email,

        @Pattern(regexp = "^(CC|CE|PP|TI)-\\d{10}$", message = "Invalid document")
        String document,

        @NotBlank(message = "Addresses are required")
        List<AddressDto> addresses
) {
    public Customer toEntity() {
        String[] documentParts = document.split("-");

        Customer customer = Customer.builder()
                .name(name)
                .phone(phone)
                .email(email)
                .document(Document.builder()
                        .type(DocumentType.valueOf(documentParts[0]))
                        .number(documentParts[1])
                        .build())
                .build();

        List<Address> addressEntities = addresses.stream()
                .map(addressDto -> Address.builder()
                        .street(addressDto.street())
                        .city(addressDto.city())
                        .state(addressDto.state())
                        .customer(customer)
                        .build())
                .collect(Collectors.toList());

        customer.setAddresses(addressEntities);
        return customer;
    }
}