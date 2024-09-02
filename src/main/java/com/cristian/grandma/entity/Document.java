package com.cristian.grandma.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@Entity
@Table(name = "document")
@NoArgsConstructor
@AllArgsConstructor
public class Document extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private DocumentType type;

    private String number;

    @OneToOne(mappedBy = "document")
    private Customer customer;


}