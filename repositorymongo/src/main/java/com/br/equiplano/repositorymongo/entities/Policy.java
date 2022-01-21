package com.br.equiplano.repositorymongo.entities;

import com.br.equiplano.entity.PolicyEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
public class Policy {
    @Id
    private String id;
    @Indexed(unique = true)
    private String numberPolicy;


    private LocalDateTime dateValidaty;
    private LocalDateTime endValidaty;
    private Vehicle vehicle;
    private BigDecimal valuePolicy;
    private Client client;


    public PolicyEntity toEntity(){

        var policy = new PolicyEntity();
        policy.setValuePolicy(this.valuePolicy);
        policy.setDateValidaty(this.dateValidaty);
        policy.setEndValidaty(this.endValidaty);
        policy.setNumberPolicy(numberPolicy);
        policy.setVehicle(vehicle.toEntity());
        policy.setClientDocument(client.getCpf());


        return policy;
    }

}
