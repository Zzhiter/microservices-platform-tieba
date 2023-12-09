package com.central.post;

import com.central.common.lb.annotation.EnableFeignInterceptor;
import com.central.search.annotation.EnableSearchClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableSearchClient
@EnableTransactionManagement
@EnableFeignInterceptor
@SpringBootApplication
public class PostCenterApp {

    public static void main(String[] args) {
        SpringApplication.run(PostCenterApp.class, args);
    }
}
