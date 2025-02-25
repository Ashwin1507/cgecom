package com.codegnan.cgecom.configurtion;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {
    // Nothing extra needed unless you need custom transaction management.
}