package ua.dudko.restreactive.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ua.dudko.restreactive.domain.Language;

public interface LanguageRepo extends ReactiveMongoRepository<Language, String> {
    Mono<Language> findByName(String name);
    Mono<Language> deleteByName(String name);
}
