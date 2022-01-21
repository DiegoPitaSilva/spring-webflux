package com.br.equiplano.entity.dto;

import com.br.equiplano.entity.VehicleEntity;
import com.br.equiplano.entity.enums.StatusPolicy;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PolicyDto {

    private Long numberDaysExpired;


    private Boolean expired;


    private BigDecimal valuePolicy;

    private String boardVehicle;

}
