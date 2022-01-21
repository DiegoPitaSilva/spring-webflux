package com.br.equiplano.commom.web.controller;

import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import com.br.equiplano.usecase.ClientCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("client")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientCase clientCase;
    @ApiOperation(value = "Cadaastro de cliente")
    @PostMapping
    public Mono<ApiCreateModel> saveClient(@RequestBody @Valid ClientEntity clientEntity) {
        logger.debug("Entrada de cliente {} ",clientEntity.toString());
        return clientCase.saveClient(clientEntity);
    }

    @ApiOperation(value = "Retorna um cliente")
    @ApiResponses(value = {
            @ApiResponse(description = "Retorna um  cliente",responseCode = "200"),

    })
    @GetMapping
    public Flux<ClientEntity> getClient(@RequestHeader(required = false) String cpfClient
                    ,@RequestHeader(required = false) String nameClient){

        return clientCase.getClients(cpfClient,nameClient);
    }



    @PutMapping
    @ApiOperation(value = "Atualizar um cliente")
    public Mono<ApiCreateModel> updateClient(@RequestHeader(required = false,name = "document") String cpfClient
            ,@RequestBody ClientEntity clientEntity){
            logger.info("atualizando cliente {}", cpfClient);

        return clientCase.updateClient(cpfClient,clientEntity);
    }

    @DeleteMapping
    public Mono<ApiCreateModel> deleteClient(@RequestHeader(name = "document")String cpfClient){
        logger.info("Delete cliente {}", cpfClient);
        return clientCase.deleteClient(cpfClient);
    }


}
