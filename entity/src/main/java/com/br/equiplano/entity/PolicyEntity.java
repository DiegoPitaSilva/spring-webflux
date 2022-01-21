package com.br.equiplano.entity;

import com.br.equiplano.entity.dto.PolicyDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyEntity {

    @NotNull
    private String numberPolicy;

    @NotNull

    private LocalDateTime dateValidaty;
    @NotNull(message = "É necessário incluir um prazo final")


    private LocalDateTime endValidaty;
    @NotNull(message = "É necessário incluir um valor para apolice")

    private BigDecimal valuePolicy;
    @NotNull(message = "É necessário incluir um automovel")
    private VehicleEntity vehicle;

    @NotEmpty(message = "É necessario incluir um client")
    @JsonProperty("cpf_Client")
    private String clientDocument;

    public PolicyDto toDto(){
         var policyDto = new PolicyDto();
         policyDto.setValuePolicy(valuePolicy);
         policyDto.setBoardVehicle(this.vehicle.getBoardVehicle());
         if (endValidaty.isAfter(LocalDateTime.now())){
             policyDto.setExpired(false);
         }else{
             policyDto.setExpired(true);
         }
         policyDto.setNumberDaysExpired(ChronoUnit.DAYS.between(dateValidaty,endValidaty));

        return policyDto;
    }



}
