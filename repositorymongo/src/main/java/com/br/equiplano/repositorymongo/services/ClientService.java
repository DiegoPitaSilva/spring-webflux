package com.br.equiplano.repositorymongo.services;

import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.exception.ClientCpfException;
import com.br.equiplano.repositorymongo.entities.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ClientService {
     Mono<ApiCreateModel> saveClient(Client client) throws ClientCpfException;
     Flux<ClientEntity> getClients(String cpfClient, String nameClient);
     Mono<ApiCreateModel> updateClient(String cpfClient,Client client);
     Mono<ApiCreateModel> deleteClient(String cpfClient);
}
