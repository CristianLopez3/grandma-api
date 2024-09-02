package com.cristian.grandma.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

    private String street;
    private String city;
    private String state;

    private boolean isDeleted = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}