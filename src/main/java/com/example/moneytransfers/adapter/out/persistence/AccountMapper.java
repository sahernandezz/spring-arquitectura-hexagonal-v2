package com.example.moneytransfers.adapter.out.persistence;

import com.example.moneytransfers.domain.Account;

public class AccountMapper {

    public static Account entityToDomain(AccountEntity accountEntity) {
        return Account.builder()
                .id(accountEntity.getId())
                .amount(accountEntity.getAmount())
                .build();
    }

    public static AccountEntity domainToEntity(Account account) {
        return AccountEntity.builder()
                .id(account.getId())
                .amount(account.getAmount())
                .build();
    }
}
