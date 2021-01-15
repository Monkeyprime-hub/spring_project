package com.example.soulmate.events;

import lombok.val;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@RestController
public class BNRestController {

    private final Set<SseEmitter> subscribers = new CopyOnWriteArraySet<>();

   @RequestMapping(method = RequestMethod.GET, value = "/news-stream")
    public SseEmitter events() {
        val emitter = new SseEmitter();
        subscribers.add(emitter);

        emitter.onTimeout(() -> subscribers.remove(emitter));
        emitter.onCompletion(() -> subscribers.remove(emitter));
        return emitter;
    }

    @Async
    @EventListener
    public void handleNews(BreakingNews breakingNews) {
        List<SseEmitter> deadEmmiters = new ArrayList<>();

        subscribers.forEach(
                emitter -> {
                    try {
                        events().send(breakingNews, MediaType.APPLICATION_JSON);
                    } catch (Exception e) {
                        deadEmmiters.add(emitter);
                    }
                }
        );
        subscribers.removeAll(deadEmmiters);
    }


}
