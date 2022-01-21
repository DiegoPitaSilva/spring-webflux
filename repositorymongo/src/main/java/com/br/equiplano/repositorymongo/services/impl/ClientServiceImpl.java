package com.br.equiplano.repositorymongo.services.impl;

import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.exception.ClientCpfException;

import com.br.equiplano.repositorymongo.entities.Client;
import com.br.equiplano.repositorymongo.repository.ClientRepository;
import com.br.equiplano.repositorymongo.services.ClientService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    private final ClientRepository clientRepository;

    @Override
    public Mono<ApiCreateModel> saveClient(Client client) throws ClientCpfException {

        return this.clientRepository.save(client)
                                        .map(c->ApiCreateModel.builder()
                                            .message(String.format("Usuário %s criado com sucesso",client.getFullNameClient()))
                                                                    .success(true).build());
    }

    @Override
    public Flux<ClientEntity> getClients(String cpfClient, String nameClient) {
        return clientRepository.findByFullNameClientOrCpf(nameClient,cpfClient)
                    .map(Client::toEntity)
                        .switchIfEmpty(clientRepository.findAll().map(Client::toEntity));
    }

    @Override
    public Mono<ApiCreateModel> updateClient(String cpfClient, Client clientEntity) {
        return this.clientRepository.findByCpf(cpfClient).map(p->{
                            clientEntity.setId(p.getId());
                            return clientEntity;})
                                        .flatMap(clientRepository::save)
                                            .map(p->ApiCreateModel.builder().message("Atualizado com sucesso ")
                                                                    .success(true).build())
                                                .switchIfEmpty(Mono.error(new ClientCpfException("")));
    }

    @Override
    public Mono<ApiCreateModel> deleteClient(String cpfClient) {
        return clientRepository.findByCpf(cpfClient)
                .switchIfEmpty(Mono.empty())
                        .filter(Objects::nonNull)
                            .flatMap(this.clientRepository::delete)
                                    .map(p->ApiCreateModel.builder().message("Deletado com sucesso ").build());

    }
}
