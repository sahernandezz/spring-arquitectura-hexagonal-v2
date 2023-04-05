package com.example.moneytransfers;

import com.example.moneytransfers.adapter.out.persistence.AccountEntity;
import com.example.moneytransfers.adapter.out.persistence.SpringAccountRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Extra implements InitializingBean {

    private final SpringAccountRepository extra;

    public Extra(SpringAccountRepository extra) {
        this.extra = extra;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.extra.save(
                AccountEntity.builder()
                        .id(1L)
                        .amount(BigDecimal.valueOf(20))
                        .build()
        );

        this.extra.save(
                AccountEntity.builder()
                        .id(2L)
                        .amount(BigDecimal.valueOf(25))
                        .build()
        );
    }
}
