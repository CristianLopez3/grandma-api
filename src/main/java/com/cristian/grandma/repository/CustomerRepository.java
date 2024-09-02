package com.cristian.grandma.repository;

import com.cristian.grandma.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("""
                SELECT c
                  FROM Customer c
                WHERE c.document.number = :documentNumber
            """)
    Optional<Customer> findByDocumentNumber(String documentNumber);

}
