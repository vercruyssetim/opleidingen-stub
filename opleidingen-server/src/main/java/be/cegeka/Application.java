package be.cegeka;

import be.cegeka.opleidingen.OpleidingRepository;
import org.elasticsearch.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public OpleidingRepository opleidingRepository(Client client) {
        return new OpleidingRepository(client);
    }
}
