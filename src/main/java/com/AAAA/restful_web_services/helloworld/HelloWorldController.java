package com.AAAA.restful_web_services.helloworld;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;
    @GetMapping (path = "/hello-worldddd")
    public String helloworld(){
        return "hello";
    }

    @GetMapping (path = "/hello-world-i18n")
    public String helloworldInternationalized(){
        Locale locale= LocaleContextHolder.getLocale();
        return  messageSource.getMessage("good.morning.message",null,"Default Message",locale);


    }

    @GetMapping (path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello");
    }

    @GetMapping (path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("hello world,%s",name));
    }
}
