package com.lcwd.user.service.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class MyConfiguration {

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate(){
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
//        clientHttpRequestFactory.setConnectTimeout(10000);
//        clientHttpRequestFactory.setConnectionRequestTimeout(10000);
//        return new RestTemplate(clientHttpRequestFactory);
        return new RestTemplate();
    }
}
