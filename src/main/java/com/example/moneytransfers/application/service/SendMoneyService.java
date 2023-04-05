package com.example.moneytransfers.application.service;

import com.example.moneytransfers.application.port.in.SendMoneyCommand;
import com.example.moneytransfers.application.port.in.SendMoneyPort;
import com.example.moneytransfers.application.port.out.LoadAccountPort;
import com.example.moneytransfers.application.port.out.UpdateAccountPort;
import com.example.moneytransfers.common.UseCase;
import com.example.moneytransfers.domain.Account;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@UseCase
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SendMoneyService implements SendMoneyPort {

    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;

    @Transactional
    @Override
    public void send(SendMoneyCommand command) {

        final Account source = loadAccountPort.load(command.getSourceId());
        final Account target = loadAccountPort.load(command.getTargetId());

        if (!source.isBalanceGreaterThan(command.getAmount())) {
            throw new RuntimeException("Source account not have enough balance amount ... ");
        }

        target.plus(command.getAmount());
        source.subtract(command.getAmount());

        updateAccountPort.update(source);
        updateAccountPort.update(target);

    }
}
