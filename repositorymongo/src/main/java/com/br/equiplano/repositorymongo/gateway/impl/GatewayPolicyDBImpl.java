package com.br.equiplano.repositorymongo.gateway.impl;

import com.br.equiplano.commom.Gateway;
import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.PolicyEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.repositorymongo.entities.Policy;
import com.br.equiplano.repositorymongo.services.PolicyService;
import com.br.equiplano.usecase.gateway.GatewayPolicyDB;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Gateway
@RequiredArgsConstructor
public class GatewayPolicyDBImpl implements GatewayPolicyDB {

    private final ModelMapper modelMapper;
    private final PolicyService policyService;

    @Override
    public Mono<ApiCreateModel> savePolicy(PolicyEntity policyEntity) {
         return this.policyService.savePolicy(modelMapper.map(policyEntity, Policy.class),policyEntity.getClientDocument());

    }

    @Override
    public Mono<PolicyEntity> getPolicy(String numberPolicy) {
        return this.policyService.getClients(numberPolicy)
                    .map(p->modelMapper.map(p,PolicyEntity.class));
    }

    @Override
    public Mono<ApiCreateModel> updatePolicy(String numerPolicy, PolicyEntity policyEntity) {
        return this.policyService.updatePolicy(numerPolicy,
                modelMapper.map(policyEntity,Policy.class));
    }

    @Override
    public Mono<ApiCreateModel> deletePolicy(String numberPolicy) {
        return this.policyService.deletePolicy(numberPolicy);
    }
}
