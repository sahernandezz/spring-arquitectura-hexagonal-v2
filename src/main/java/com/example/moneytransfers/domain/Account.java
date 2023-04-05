package com.example.moneytransfers.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Account {

    private Long id;

    private BigDecimal amount;

    public Boolean isBalanceGreaterThan(BigDecimal anotherAmount) {
        return this.amount.compareTo(anotherAmount) >= 0;
    }

    public void plus(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }

    public void subtract(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
    }
}
