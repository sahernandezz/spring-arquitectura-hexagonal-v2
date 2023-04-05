package com.example.moneytransfers.adapter.out.persistence;

import com.example.moneytransfers.application.port.out.LoadAccountPort;
import com.example.moneytransfers.application.port.out.UpdateAccountPort;
import com.example.moneytransfers.common.PersistenceAdapter;
import com.example.moneytransfers.domain.Account;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {

    private final SpringAccountRepository accountRepository;

    @Override
    public Account load(Long id) {
        return accountRepository
                .findById(id)
                .map(AccountMapper::entityToDomain)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(AccountMapper.domainToEntity(account));
    }
}
