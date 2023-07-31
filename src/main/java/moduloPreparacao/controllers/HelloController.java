package moduloPreparacao.controllers;

import config.RestTemplateConfig;
import moduloPreparacao.services.OrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootConfiguration
@Import(RestTemplateConfig.class)
@RestController
public class HelloController {
    @Autowired
    private OrderProcessor orderProcessor;

    @GetMapping("/")
    public String index() {
        return "Hello Spring Boot";
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return orderProcessor.test();
    }
}
