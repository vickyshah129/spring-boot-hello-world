package com.example.docker_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    /*@Value("${service.to.call}")
    private String serviceName;

    @Value("${service.port}")
    private String servicePort;*/

    public static String serviceName="employeems";
    public static int servicePort=8080;

    public static String productServiceName="productms";
    public static int productServicePort=8080;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/health")
    public String getHealth(){
        return "{\n" +
                "\t\"health\" : \"OK\",\n" +
                "\t\"serviceName\" : \"order_ms\",\n" +
                "\t\"version\" : \"1.0\"\n" +
                "}";
    }

    @GetMapping("/callToEmployee")
    public String callEmployeeMS(){
        String url = "http://"+serviceName+":"+servicePort+"/health";
        System.out.println("url="+url);
        String response = "";
        try{
            response = restTemplate.getForObject(url,String.class);
            return "Response from employee service= "+response;
        }catch(Exception e){
            return "Response from employee service= ERROR";
        }
    }

    @GetMapping("/callToProduct")
    public String callProductMS(){
        String url = "http://"+productServiceName+":"+productServicePort+"/health";
        System.out.println("url="+url);
        String response = "";
        try{
            response = restTemplate.getForObject(url,String.class);
            return "Response from employee service= "+response;
        }catch(Exception e){
            return "Response from employee service= ERROR";
        }
    }
}
