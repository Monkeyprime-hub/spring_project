package com.example.soulmate;

import com.example.soulmate.profiling.SaySomething;
import com.example.soulmate.profiling.SaySomethingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableAsync
@EnableTransactionManagement
@ServletComponentScan
@SpringBootApplication
@EnableJpaRepositories
public class SoulmateApplication {


    public static void main(String[] args) {
        SpringApplication.run(SoulmateApplication.class, args);
    }


}
