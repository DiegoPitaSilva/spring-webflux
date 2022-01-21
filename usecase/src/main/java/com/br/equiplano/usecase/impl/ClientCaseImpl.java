package com.br.equiplano.usecase.impl;

import com.br.equiplano.commom.UseCase;
import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.usecase.ClientCase;
import com.br.equiplano.usecase.gateway.GatewayClientDB;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@UseCase
@RequiredArgsConstructor
public class ClientCaseImpl implements ClientCase {


    private final GatewayClientDB gatewayClientDB;


    @Override
    public Mono<ApiCreateModel> saveClient(ClientEntity clientEntity) {

       return gatewayClientDB.saveClient(clientEntity);
    }

    @Override
    public Flux<ClientEntity> getClients(String cpfClient, String nameClient) {
        return gatewayClientDB.getClients(cpfClient,nameClient);
    }

    @Override
    public Mono<ApiCreateModel> updateClient(String cpfClient, ClientEntity clientEntity) {
        return gatewayClientDB.updateClient(cpfClient,clientEntity);
    }

    @Override
    public Mono<ApiCreateModel> deleteClient(String cpfClient) {
        return gatewayClientDB.deleteClient(cpfClient);
    }
}
