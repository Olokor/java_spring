package com.luv2code.springboot.demo.mycoolapp.Rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teamInfo")
    public String teamInfo() {return "team info: " + teamName + ", coach name: " + coachName;}

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getWorkout() {return "Run 5km per day";}

    @GetMapping("/fortune")
    public String getFortune() {return "this is your lucky day";}
}
