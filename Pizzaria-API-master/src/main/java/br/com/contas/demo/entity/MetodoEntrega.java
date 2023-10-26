package br.com.contas.demo.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum MetodoEntrega {
    DELIVERY(0),

    BALCAO(1);

    private final int value;

    MetodoEntrega(int value) {
        this.value = value;
    }
}
