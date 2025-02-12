package com.luv2code.springcorddemo.rest;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Your Game Time is 12pm!!!!";
    }
}
