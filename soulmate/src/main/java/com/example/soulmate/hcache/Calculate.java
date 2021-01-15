package com.example.soulmate.hcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class Calculate {

    @Cacheable("hcache")
    public int sum(int a, int b) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return a + b;
    }
}
