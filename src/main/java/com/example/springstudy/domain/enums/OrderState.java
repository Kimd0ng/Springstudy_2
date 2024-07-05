package com.example.springstudy.domain.enums;

public enum OrderState {
    READY(1),
    REFUND(2),
    COMPLETE(3);

    private final int weight;

    OrderState(int weight) {
        this.weight = weight;
    }
}
