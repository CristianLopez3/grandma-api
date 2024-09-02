package com.cristian.grandma.controller;

import com.cristian.grandma.dto.CustomerDto;
import com.cristian.grandma.dto.CustomerRequestDto;
import com.cristian.grandma.entity.Customer;
import com.cristian.grandma.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final CustomerServiceImpl customerService;

    @PostMapping
    ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        logger.info("Creating customer: {}", customerRequestDto);
        Customer customer = customerRequestDto.toEntity();
        return ResponseEntity.ok(customerService.save(customer));
    }

}