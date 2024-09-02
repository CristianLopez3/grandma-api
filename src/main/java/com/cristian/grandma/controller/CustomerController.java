package com.cristian.grandma.controller;

import com.cristian.grandma.dto.CustomerDto;
import com.cristian.grandma.dto.CustomerRequestDto;
import com.cristian.grandma.entity.Customer;
import com.cristian.grandma.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerServiceImpl customerService;

    @PostMapping
    ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        logger.info("Creating customer: {}", customerRequestDto);
        Customer customer = customerRequestDto.toEntity();
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping("{documentNumber}")
    ResponseEntity<CustomerDto> getCustomerByDocumentNumber(@PathVariable String documentNumber) {
        logger.info("Getting customer by document number: {}", documentNumber);
        return ResponseEntity.ok(customerService.findByDocumentNumber(documentNumber));
    }

    @DeleteMapping("{documentNumber}")
    ResponseEntity<Void> deleteCustomerByDocumentNumber(@PathVariable String documentNumber) {
        logger.info("Deleting customer by document number: {}", documentNumber);
        customerService.deleteByDocumentNumber(documentNumber);
        return ResponseEntity.noContent().build();
    }

}
