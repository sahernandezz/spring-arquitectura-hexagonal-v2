package com.example.moneytransfers.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendMoneyCommand {
    private Long sourceId;
    private Long targetId;
    private BigDecimal amount;
}
