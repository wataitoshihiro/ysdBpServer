package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.service.TestService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.io.CharConversionException;
import java.io.FileNotFoundException;

@RestController
public class WelcomeTestController2 {

    private TestService testService ;
    private TestService testService2 ;
    
    private String welcomeMessage;
//    private String welcomeMessage="hello !!!";

    public WelcomeTestController2(
        @Value("${welcome_message}") String welcomeMessage,
        @Qualifier("TestServiceImpl1") TestService testService,
        @Qualifier("TestServiceImpl2") TestService testService2
    ) {
        this.welcomeMessage = welcomeMessage;
        this.testService = testService;
        this.testService2 = testService2;
    }

    @GetMapping("/err5")
    public String sayHello4() throws FileNotFoundException {
        throw new FileNotFoundException("FileNotFoundException test");
//        return "--- c ---";
    }

    @GetMapping("/err6")
    public String sayHello5() throws HttpRequestMethodNotSupportedException {
        throw new HttpRequestMethodNotSupportedException("HttpRequestMethodNotSupportedException test");
//        return "--- c ---";
    }

    @GetMapping("/aop1")
    public String test01() {
//        throw new IllegalArgumentException("--- a2 ---");
        return testService.getService();
    }

    @GetMapping("/aop2")
    public String test02() {
//        throw new IllegalArgumentException("--- a2 ---");
        if (testService2.getService() == null){
            return "[occured null pointer exception.] ---> [OK !]";
        }
        return testService2.getService();
    }

    
//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler({ FileNotFoundException.class })
//    @ResponseBody
//    public Map<String, Object> handleError() {
//        Map<String, Object> errorMap = new HashMap<>();
//        errorMap.put("message", "WelcomeTestControllerでハンドリングした！");
//        errorMap.put("status", HttpStatus.OK);
//        return errorMap;
//    }
}
