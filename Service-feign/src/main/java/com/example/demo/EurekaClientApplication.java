package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import config.MyConfiguration;

@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
//@EnableFeignClients(defaultConfiguration = MyConfiguration.class) //全局配置
@SpringBootApplication
//@RibbonClients(
//      //配置defaultConfiguration会报空指针异常，有知道的同学麻烦告诉下
//      //defaultConfiguration=RibbonClientConfiguration.class, 
//      value= {
//  @RibbonClient(name="service-hello",configuration=MyConfiguration.class)
//})
//@RibbonClient(name="service-hello",configuration=MyConfiguration.class)
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
}
