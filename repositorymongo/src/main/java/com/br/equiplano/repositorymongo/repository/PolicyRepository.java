package com.br.equiplano.repositorymongo.repository;

import com.br.equiplano.repositorymongo.entities.Policy;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PolicyRepository extends ReactiveMongoRepository<Policy,String> {

    Mono<Policy> findByNumberPolicy(String numberPolicy);
}
