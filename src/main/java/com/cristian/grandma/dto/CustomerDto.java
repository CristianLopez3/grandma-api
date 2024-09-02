package com.cristian.grandma.dto;


import com.cristian.grandma.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

public record CustomerDto(
        String name,
        String document,
        List<AddressDto> addresses
) {
    public static CustomerDto fromEntity(Customer customer) {
        return new CustomerDto(
                customer.getName(),
                customer.getDocument().getType() + "-" + customer.getDocument().getNumber(),
                customer.getAddresses().stream()
                        .map(AddressDto::fromEntity)
                        .collect(Collectors.toList())
        );
    }
}