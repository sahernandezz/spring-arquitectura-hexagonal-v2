package com.example.moneytransfers.application.port.out;

import com.example.moneytransfers.domain.Account;

public interface LoadAccountPort {
    Account load(Long id);
}