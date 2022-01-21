package com.br.equiplano.usecase.gateway;

import com.br.equiplano.entity.PolicyEntity;
import com.br.equiplano.entity.model.ApiCreateModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GatewayPolicyDB {
    Mono<ApiCreateModel> savePolicy(PolicyEntity policyEntity);

    Mono<PolicyEntity> getPolicy(String numberPolicy);

    Mono<ApiCreateModel> updatePolicy(String numerPolicy, PolicyEntity policyEntity);

    Mono<ApiCreateModel> deletePolicy(String numberPolicy);
}
