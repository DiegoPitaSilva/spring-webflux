package com.br.equiplano.commom.web.controller;

import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.PolicyEntity;
import com.br.equiplano.entity.dto.PolicyDto;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.usecase.ClientCase;
import com.br.equiplano.usecase.PolicyCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("policy")
public class PolicyController {

	private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

	private final PolicyCase policyCase;


	@PostMapping
	public Mono<ApiCreateModel> savePolicy(@RequestBody @Valid PolicyEntity policyEntity) {
		logger.debug("Entrada de APOLICE {} ",policyEntity.toString());
		return policyCase.savePolicy(policyEntity);
	}

	@GetMapping
	public Mono<PolicyEntity> getPolicy(@RequestHeader(required = false) String numberPolicy
			){

		return policyCase.getPolicy(numberPolicy);
	}



	@PutMapping
	public Mono<ApiCreateModel> updatePolicy(@RequestHeader(required = false,name = "number_policy") String numerPolicy
			,@RequestBody PolicyEntity policyEntity){
		logger.info("atualizando apolice {}", policyEntity);

		return policyCase.updatePolicy(numerPolicy,policyEntity);
	}

	@DeleteMapping
	public Mono<ApiCreateModel> deleteClient(@RequestHeader(name = "number_policy")String numberPolicy){
		logger.info("Delete cliente {}", numberPolicy);
		return policyCase.deletePolicy(numberPolicy);
	}

	@GetMapping("/search")
	public Mono<PolicyDto> searchPolicy(@RequestHeader(required = false) String numberPolicy
	){

		return policyCase.getPolicy(numberPolicy).map(PolicyEntity::toDto);
	}


}
