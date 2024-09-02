package com.cristian.grandma.service.impl;

import com.cristian.grandma.dto.CustomerDto;
import com.cristian.grandma.entity.Customer;
import com.cristian.grandma.repository.*;
import com.cristian.grandma.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto save(Customer customer) {
        return CustomerDto.fromEntity(customerRepository.save(customer));
    }

    @Override
    public CustomerDto findByDocumentNumber(String number) {
        return CustomerDto
                .fromEntity(customerRepository.findByDocumentNumber(number)
                .orElseThrow());

    }

    @Override
    public void deleteByDocumentNumber(String number) {
        Customer customer = customerRepository.findByDocumentNumber(number)
                .orElseThrow();

        customer.setDeleted(true);

        customer.getAddresses().forEach(address -> address.setDeleted(true));
        customerRepository.save(customer);


    }


}