package com.br.equiplano.exception.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {

    private String errorCode;

    private String message;

}
