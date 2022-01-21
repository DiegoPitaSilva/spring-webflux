package com.br.equiplano.exception.handle;

import com.br.equiplano.exception.ClientCpfException;
import com.br.equiplano.exception.model.ApiError;
import com.mongodb.MongoWriteException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class HandleException  {

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<Object> handleAllExceptions(Exception ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ApiError error = ApiError.builder().errorCode("Server Error").message("Error, por favor verifique se já existe cadastro ")
                .build();
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


   @ExceptionHandler(MethodArgumentNotValidException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        var error = ApiError.builder().errorCode("Fault parameter").message(details.toString());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MongoWriteException.class)
    public  ResponseEntity<ApiError> mongoWriteException(MongoWriteException mongoWriteException){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiError.builder().errorCode("MDB-01")
                        .message("Erro ao gravar as informações no banco, por favor verifique seu payload.").build());

    }



    @ExceptionHandler(ClientCpfException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public final Mono<ApiError> clienteCpfException(ClientCpfException clientCpfException){
        return Mono.just(ApiError
                        .builder()
                            .errorCode("406 Not Acceptable")
                                .message("O CPF informado já existe ...")
                                    .build());
    }

}
