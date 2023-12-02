package com.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Rocketmq事务 demo
 *
 * @author buaa
 */
@EnableTransactionManagement
@SpringBootApplication
public class RocketMqTxApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqTxApplication.class, args);
    }
}
