package com.br.equiplano.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ClientEntity {
    @NotNull
    @NotEmpty(message = "Nome do cliente é necessário")
    @JsonProperty(value = "full_name_client")
    private String fullNameClient;

    @NotNull(message = "Cpf do cliente não pode ser nulo")
    @NotEmpty(message = "Nome do cliente não pode ser em branco")
    private String cpf;

    @NotNull
    private AddressEntity address;


}
