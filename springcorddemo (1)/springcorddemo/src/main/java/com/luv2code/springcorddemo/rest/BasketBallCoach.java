package com.luv2code.springcorddemo.rest;

import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "practice your jumps and throw 45mins daily....";
    }
}
