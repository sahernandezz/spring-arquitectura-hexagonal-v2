package com.example.moneytransfers.application.port.in;

public interface SendMoneyPort {
    void send(SendMoneyCommand command);
}
