package com.br.equiplano.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class VehicleEntity {
    @NotNull(message = "É necessário incluir uma placa do veiculo")
    @NotEmpty(message = "É necessario incluir uma placa")
    private String boardVehicle;
}
