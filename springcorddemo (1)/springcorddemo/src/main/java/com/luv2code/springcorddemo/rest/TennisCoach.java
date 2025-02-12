package com.luv2code.springcorddemo.rest;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "practice your smarsh shots durning every game";
    }
}
