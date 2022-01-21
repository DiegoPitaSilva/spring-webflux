package com.br.equiplano.repositorymongo.repository;
import com.br.equiplano.repositorymongo.entities.Client;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

    Mono<Client> findByCpf(String cpf);
    Flux<Client> findByFullNameClientOrCpf(String fullNameClient,String cpf);
    Mono<Client> deleteByCpf(String cpf);
}
