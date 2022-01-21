package com.br.equiplano.repositorymongo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private String city;
    private String uf;
}
