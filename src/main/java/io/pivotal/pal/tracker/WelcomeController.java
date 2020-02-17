package io.pivotal.pal.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tx.util.StopWatch;

@RestController
public class WelcomeController {
    private static Logger logger = LoggerFactory.getLogger(WelcomeController.class);

//    private String welcomeMessage;
//    private String welcomeMessage="hello !!!";

    public WelcomeController(
//        @Value("${welcome_message}") String welcomeMessage
    ) {
//        this.welcomeMessage = welcomeMessage;
    }

    @GetMapping("/")
//    public String sayHello() {
//        return welcomeMessage;
//    }
    public String sayHello() {
        return "-> hello !!!";
    }

}
