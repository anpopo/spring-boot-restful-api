package study.springbootrestfulapi.helloworld;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final MessageSource messageSource;

    // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping("/hello-world")
    public  String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public  HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public  HelloWorldBean helloWorldBean(@PathVariable("name") String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping("/hello-world-international-message")
    public Map<String, String> internationalization(@RequestHeader(value = "Accept-Language", required = false)Locale locale) {
        return Map.of("message" , messageSource.getMessage("greeting", null, locale));
    }
}
