package com.br.equiplano.repositorymongo.services;

import com.br.equiplano.entity.PolicyEntity;
import com.br.equiplano.entity.model.ApiCreateModel;

import com.br.equiplano.repositorymongo.entities.Policy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PolicyService {
    Mono<ApiCreateModel> savePolicy(Policy policy,String clientCpf);
    Mono<PolicyEntity> getClients(String numberPolicy);
    Mono<ApiCreateModel> updatePolicy(String number,Policy policy);
    Mono<ApiCreateModel> deletePolicy(String numberPolicy);

}
