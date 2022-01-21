package com.br.equiplano.repositorymongo.entities;

import com.br.equiplano.entity.AddressEntity;
import com.br.equiplano.entity.ClientEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Client {
    @Id
    private String id;
    private String fullNameClient;
    @Indexed(unique = true)
    private String cpf;
    private Address address;


    public   ClientEntity toEntity(){
        var clientEntity= new ClientEntity();
        var addressEntity= new AddressEntity();
        addressEntity.setCity(this.address.getCity());
        addressEntity.setUf(this.address.getUf())
        ;
       clientEntity.setFullNameClient(getFullNameClient());
        clientEntity.setCpf(cpf);
        clientEntity.setAddress(addressEntity);

        return clientEntity;
    }
}
