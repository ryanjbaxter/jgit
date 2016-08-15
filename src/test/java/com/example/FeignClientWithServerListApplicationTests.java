package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.junit.Assert.assertTrue;


import com.example.FeignClientWithServerListApplicationTests.TestApplication;

/**
 * Created by ryanjbaxter on 8/15/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebIntegrationTest(randomPort = true, value = "myexample.ribbon.listOfServers:www.example.com")
@DirtiesContext
public class FeignClientWithServerListApplicationTests {

    @Autowired
    private RestClient client;

    @Test
    public void clientConnects() {
        System.out.println(client.hello());
        assertTrue(client.hello().contains("<html"));


    }

    @Configuration
    @EnableAutoConfiguration
    @EnableFeignClients
    protected static class TestApplication {

        public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);
        }
    }

    @FeignClient("myexample")
    static interface RestClient {
        @RequestMapping(value="/", method= RequestMethod.GET)
        String hello();
    }

}
