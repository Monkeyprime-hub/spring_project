package com.example.soulmate.profiling;


import com.example.soulmate.inject_random.InjectRandomInt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Profiling
@Scope("prototype")
@Component
public class SaySomethingImpl implements SaySomething {

    @Value("Hello man!")
    private String message;
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @Override
    public void say() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message= " + message);
        }
    }
}

// C:\Users\User\Desktop\java-docker-master\soulmate\src\main\java\com\example\soulmate\profiling