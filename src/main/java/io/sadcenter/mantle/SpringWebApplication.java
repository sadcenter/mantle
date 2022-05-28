package io.sadcenter.mantle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringWebApplication.class, args);
  }
}
