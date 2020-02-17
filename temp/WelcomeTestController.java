package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.net.BindException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeTestController {

    private String welcomeMessage;
//    private String welcomeMessage="hello !!!";

    public WelcomeTestController(
        @Value("${welcome_message}") String welcomeMessage
    ) {
        this.welcomeMessage = welcomeMessage;
    }

    @GetMapping("/err1")
    public String sayHello2() {
        throw new IllegalArgumentException("IllegalArgumentException test");
//        return "--- a ---";
    }

    @GetMapping("/err2")
    public String sayHello3() throws CharConversionException {
        throw new CharConversionException("CharConversionException test");
//        return "--- b ---";
    }

    @GetMapping("/err3")
    public String sayHello4() throws FileNotFoundException {
        throw new FileNotFoundException("FileNotFoundException test");
//        return "--- c ---";
    }

    @GetMapping("/err4")
    public String sayHello6() throws RuntimeException {
        throw new RuntimeException("RuntimeException test");
//        return "--- c ---";
    }
    
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ FileNotFoundException.class })
    @ResponseBody
    public Map<String, Object> handleError() {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("message", "コントローラー（WelcomeTestController）でハンドリングした！");
        errorMap.put("status", HttpStatus.OK);
        return errorMap;
    }
}
