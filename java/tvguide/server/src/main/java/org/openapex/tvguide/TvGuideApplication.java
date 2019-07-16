package org.openapex.tvguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("org.openapex.tvguide")
@EnableJpaRepositories("org.openapex.tvguide")
@EntityScan("org.openapex.tvguide")
public class TvGuideApplication {
    public static void main(String[] args) {
        SpringApplication.run(TvGuideApplication.class, args);
    }
}
