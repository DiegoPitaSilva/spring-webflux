package com.br.equiplano.entity.enums;

public enum StatusPolicy {
    VALID("VÁLIDA"),EXPIRED("EXPIRADA");

    private String status;

    StatusPolicy(String status) {
        this.status = status;
    }

    public String obterStatus(){

        return this.status;
    }
}
