package com.cristian.grandma.dto;

import com.cristian.grandma.entity.Address;

public record AddressDto(
        String street,
        String city,
        String state,
        String zipCode
) {
    public static AddressDto fromEntity(Address address) {
        return new AddressDto(
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipCode()
        );
    }
}