package org.openapex.tvguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("org.openapex.tvguide")
@EnableJpaRepositories("org.openapex.tvguide")
@EntityScan("org.openapex.tvguide")
//@EnableAutoConfiguration
//@EnableWebMvc
public class TvGuideApplication {
    public static void main(String[] args) {
        SpringApplication.run(TvGuideApplication.class, args);
    }
}
