package com.br.equiplano.entity;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AddressEntity {

    @NotNull
    @NotEmpty(message = "Não pode ser vazio o campo cidade")
    private String city;
    @NotNull
    @NotEmpty(message = "Não pode ser vazio o campo uf")
    private String uf;
}
