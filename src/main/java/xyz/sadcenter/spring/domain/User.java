package xyz.sadcenter.spring.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    private final String name, cape;

    public User(String name, String cape) {
        this.name = name;
        this.cape = cape;
    }

    public String getName() {
        return name;
    }

    public String getCape() {
        return cape;
    }
}
