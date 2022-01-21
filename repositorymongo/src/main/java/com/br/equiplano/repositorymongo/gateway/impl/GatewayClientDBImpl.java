package com.br.equiplano.repositorymongo.gateway.impl;

import com.br.equiplano.commom.Gateway;
import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.exception.ClientCpfException;
import com.br.equiplano.repositorymongo.entities.Client;
import com.br.equiplano.repositorymongo.services.ClientService;
import com.br.equiplano.usecase.gateway.GatewayClientDB;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Gateway
@Slf4j
public class GatewayClientDBImpl implements GatewayClientDB {

    private final ModelMapper modelMapper;
    private final ClientService clientService;

    public GatewayClientDBImpl(ModelMapper modelMapper, ClientService clientService) {

        this.modelMapper = modelMapper;
        this.clientService = clientService;
    }

    @Override
    public Mono<ApiCreateModel> saveClient(ClientEntity clientEntity) throws ClientCpfException {
        return clientService.saveClient(modelMapper.map(clientEntity, Client.class));

    }

    @Override
    public Flux<ClientEntity> getClients(String cpfClient, String nameClient) {
        return clientService.getClients(cpfClient,nameClient);
    }

    @Override
    public Mono<ApiCreateModel> updateClient(String cpfClient, ClientEntity clientEntity) {
        return clientService.updateClient(cpfClient,modelMapper.map(clientEntity,Client.class));
    }


    @Override
    public Mono<ApiCreateModel> deleteClient(String cpfClient) {
        return clientService.deleteClient(cpfClient);
    }

}
