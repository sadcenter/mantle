package xyz.sadcenter.spring;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sadcenter on 16.12.2020
 * @project mantle
 */
@SpringBootApplication
public class SpringWebApplication {

    private static MongoCollection<Document> mongoCollection;

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
        mongoCollection = MongoClients.create(MongoClientSettings.builder().applyConnectionString(new ConnectionString(
                "mongodb://127.0.0.1:27017")).credential(
                        MongoCredential.createCredential(
                                "root", "admin", "cos".toCharArray()))
                .build()).getDatabase("capes").getCollection("capes");
    }

    public static MongoCollection<Document> getMongoCollection() {
        return mongoCollection;
    }

}
