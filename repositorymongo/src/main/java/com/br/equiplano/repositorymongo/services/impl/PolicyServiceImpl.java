package com.br.equiplano.repositorymongo.services.impl;

import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.PolicyEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.repositorymongo.entities.Client;
import com.br.equiplano.repositorymongo.entities.Policy;
import com.br.equiplano.repositorymongo.repository.ClientRepository;
import com.br.equiplano.repositorymongo.repository.PolicyRepository;
import com.br.equiplano.repositorymongo.services.PolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class PolicyServiceImpl implements PolicyService {

    private final ClientRepository clientRepository;
    private final PolicyRepository policyRepository;




    @Override
    public Mono<ApiCreateModel> savePolicy(Policy policy, String clientCpf) {

        log.info("Query {} clients ", clientCpf);
        return clientRepository.findByCpf(clientCpf)
                                    .map(client->{
                                                                      policy.setClient(client);
                                        return policy;
                                    })
                .flatMap(policyRepository::save)

                .map(p-> ApiCreateModel.builder()
                                            .message("Criado com sucesso")
                                                .success(true)
                                            .build())
                                        .switchIfEmpty(Mono.just(ApiCreateModel
                                                    .builder()
                                                            .success(false)
                                                                    .message("Cliente não existe").build()));


    }

    @Override
    public Mono<PolicyEntity> getClients(String numberPolicy) {
        return policyRepository.findByNumberPolicy(numberPolicy)
                    .map(Policy::toEntity)
                        .switchIfEmpty(Mono.empty());


    }

    @Override
    public Mono<ApiCreateModel> updatePolicy(String cpfClient, Policy policy) {
        return null;
    }

    @Override
    public Mono<ApiCreateModel> deletePolicy(String numberPolicy) {
        return policyRepository.findByNumberPolicy(numberPolicy)
                .switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(this.policyRepository::delete)
                .map(p->ApiCreateModel.builder().message("Deletado com sucesso ")
                        .build());


    }





}
