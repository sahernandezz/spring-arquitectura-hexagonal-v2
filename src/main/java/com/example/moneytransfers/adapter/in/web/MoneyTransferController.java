package com.example.moneytransfers.adapter.in.web;

import com.example.moneytransfers.application.port.in.SendMoneyCommand;
import com.example.moneytransfers.application.port.in.SendMoneyPort;
import com.example.moneytransfers.common.WebAdapter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@WebAdapter
@RestController
@RequestMapping("/api/v1/accounts")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MoneyTransferController {

    private final SendMoneyPort sendMoneyPort;

    @PostMapping(path = "/transfer/{sourceAccountId}/{targetAccountId}/{amount}")
    void transfer(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") BigDecimal amount
    ) {

        sendMoneyPort.send(
                SendMoneyCommand.builder()
                        .sourceId(sourceAccountId)
                        .targetId(targetAccountId)
                        .amount(amount)
                        .build()
        );
    }

}
