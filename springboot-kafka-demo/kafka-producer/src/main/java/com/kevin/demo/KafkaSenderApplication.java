package com.kevin.demo;

import com.kevin.demo.kafka.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KafkaSenderApplication {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext app = SpringApplication.run(KafkaSenderApplication.class, args);

        while (true) {
            Producer sender = app.getBean(Producer.class);
            sender.send();

            Thread.sleep(5000);

        }
    }
}
