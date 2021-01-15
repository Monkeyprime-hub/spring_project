package com.example.soulmate.profiling;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Profiling
@Component
public class SaySomethingImpl implements SaySomething {

    @Value("Hello man!")
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void say() {
        System.out.println("message= " + message);
    }
}

// C:\Users\User\Desktop\java-docker-master\soulmate\src\main\java\com\example\soulmate\profiling