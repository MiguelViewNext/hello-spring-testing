/*package com.example.hellospring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HelloSpringApplication {

    static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication, args)
    }

}*/

package com.example.hellospring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args)
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name)
    }

    @GetMapping("/")
    public String myhello(@RequestParam(value = "name", defaultValue = "World") String name,
                          @RequestParam(value = "profe", defaultValue = "Miguel") String profe)
    {
        return String.format("Hello %s, my new method is called %s!", profe, name)
    }

    @RequestMapping("/add")
        public @ResponseBody Float add(
            @RequestParam(name="a") Float a,
            @RequestParam(name="b") Float b
    ) {
            return a + b;
        }

}
