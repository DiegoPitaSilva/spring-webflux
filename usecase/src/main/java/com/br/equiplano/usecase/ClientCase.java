package com.br.equiplano.usecase;

;import com.br.equiplano.entity.ClientEntity;
import com.br.equiplano.entity.model.ApiCreateModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ClientCase {
     Mono<ApiCreateModel> saveClient(ClientEntity clientEntity);
     Flux<ClientEntity> getClients(String cpfClient,String nameClient);
     Mono<ApiCreateModel> updateClient(String cpfClient,ClientEntity clientEntity);
     Mono<ApiCreateModel> deleteClient(String cpfClient);
}
