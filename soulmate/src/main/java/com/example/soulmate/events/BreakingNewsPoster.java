package com.example.soulmate.events;

import lombok.val;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
public class BreakingNewsPoster {

    private ApplicationEventPublisher publisher;

    public BreakingNewsPoster(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @PostConstruct
    public void start() {
        executorService.schedule(this::action, 5, TimeUnit.SECONDS);
    }

    private void action() {
        val news = new BreakingNews();
        news.setData("news: " + ThreadLocalRandom.current().nextInt(20));
        publisher.publishEvent(news);
        executorService.schedule(this::action, ThreadLocalRandom.current().nextInt(20), TimeUnit.SECONDS);
    }
}
