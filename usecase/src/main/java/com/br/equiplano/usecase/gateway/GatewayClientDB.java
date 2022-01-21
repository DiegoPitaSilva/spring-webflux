package com.br.equiplano.usecase.gateway;

import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.exception.ClientCpfException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GatewayClientDB {
    Mono<ApiCreateModel> saveClient(ClientEntity clientEntity) throws ClientCpfException;
    Flux<ClientEntity> getClients(String cpfClient, String nameClient);
    Mono<ApiCreateModel> updateClient(String cpfClient,ClientEntity clientEntity);
    Mono<ApiCreateModel> deleteClient(String cpfClient);
}

