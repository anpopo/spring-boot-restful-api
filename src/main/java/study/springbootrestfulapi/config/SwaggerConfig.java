package study.springbootrestfulapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api () {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo("Spring Boot Restful API practice", "인프런을 보고 만드는 spring boot restful api", "V1", "urn:tos", new Contact("Anpopo", "https://anpopo.tistory.com", "dkstpgud@gmail.com"), "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>()))
                .produces(new HashSet<>(List.of("application/json")))
                .consumes(new HashSet<>(List.of("application/json")));
    }

}
