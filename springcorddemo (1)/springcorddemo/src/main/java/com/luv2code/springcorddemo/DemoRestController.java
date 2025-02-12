package com.luv2code.springcorddemo;

import com.luv2code.springcorddemo.rest.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    private Coach myCoach;
    private Coach footballCoach;

//    @Autowired
//    public DemoRestController(Coach myCoach) {
//        this.myCoach = myCoach;
//    }
    @Autowired
    public DemoRestController(@Qualifier("basketBallCoach") Coach myCoach,
                              @Qualifier("footballCoach") Coach footballCoach) {
        this.myCoach = myCoach;
        this.footballCoach = footballCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/football")
    public String football() {
        return footballCoach.getDailyWorkout();
    }
}
