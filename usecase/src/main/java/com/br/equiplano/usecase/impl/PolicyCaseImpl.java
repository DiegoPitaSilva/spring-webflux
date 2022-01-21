package com.br.equiplano.usecase.impl;

import com.br.equiplano.commom.UseCase;
import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.PolicyEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.usecase.PolicyCase;
import com.br.equiplano.usecase.gateway.GatewayPolicyDB;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Mono;

@UseCase
@RequiredArgsConstructor
@RequestMapping("policy")
public class PolicyCaseImpl implements PolicyCase {

    private final GatewayPolicyDB gatewayPolicyDB;

    @Override
    public Mono<ApiCreateModel> savePolicy(PolicyEntity policyEntity) {
                return this.gatewayPolicyDB.savePolicy(policyEntity);
    }

    @Override
    public Mono<PolicyEntity> getPolicy(String numberPolicy) {
        return gatewayPolicyDB.getPolicy(numberPolicy);
    }

    @Override
    public Mono<ApiCreateModel> updatePolicy(String numerPolicy, PolicyEntity policyEntity) {
        return gatewayPolicyDB.updatePolicy(numerPolicy,policyEntity);
    }

    @Override
    public Mono<ApiCreateModel> deletePolicy(String numberPolicy) {
        return gatewayPolicyDB.deletePolicy(numberPolicy);
    }
}
