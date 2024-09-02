package com.cristian.grandma.service;

import com.cristian.grandma.dto.CustomerDto;
import com.cristian.grandma.entity.Customer;

public interface CustomerService {
    CustomerDto save(Customer customer);
    CustomerDto findByDocumentNumber(String number);
    void deleteByDocumentNumber(String number);
}
