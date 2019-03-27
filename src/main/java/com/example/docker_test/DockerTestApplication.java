package com.example.docker_test;

import com.example.docker_test.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@SpringBootApplication
public class DockerTestApplication {

    public static void main(String[] args) {
        /*if(args.length < 2){
            System.out.println("provide both 'hostname' and 'port' of other service");
            System.exit(1);
        }
        TestController.serviceName=args[0];
        TestController.servicePort=args[1];*/
        SpringApplication.run(DockerTestApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
