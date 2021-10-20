package xyz.sadcenter.mantle.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import xyz.sadcenter.mantle.domain.User;

import java.util.concurrent.CompletableFuture;

@Repository @CacheConfig(cacheNames = {"users"})
public interface UserRepository extends MongoRepository<User, String> {

    @Async @Cacheable(key = "#name")
    CompletableFuture<User> findByName(String name);

}
