package com.example.moneytransfers.application.port.out;

import com.example.moneytransfers.domain.Account;

public interface UpdateAccountPort {

    void update(Account account);
}
