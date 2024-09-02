package com.cristian.grandma.service;

import com.cristian.grandma.dto.CustomerDto;
import com.cristian.grandma.entity.Customer;
import com.cristian.grandma.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl {

    private final CustomerRepository customerRepository;

    public CustomerDto save(Customer customer) {
        return CustomerDto.fromEntity(customerRepository.save(customer));
    }

}