package com.cristian.grandma.dto;

import com.cristian.grandma.entity.Address;
import com.cristian.grandma.entity.Customer;
import com.cristian.grandma.entity.Document;
import com.cristian.grandma.entity.DocumentType;

import java.util.List;
import java.util.stream.Collectors;

public record CustomerRequestDto(
        String name,
        String document,
        List<AddressDto> addresses
) {
    public Customer toEntity() {
        String[] documentParts = document.split("-");

        Customer customer = Customer.builder()
                .name(name)
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
                        .zipCode(addressDto.zipCode())
                        .customer(customer)
                        .build())
                .collect(Collectors.toList());

        customer.setAddresses(addressEntities);
        return customer;
    }
}