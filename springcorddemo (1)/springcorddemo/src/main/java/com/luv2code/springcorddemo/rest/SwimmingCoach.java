package com.luv2code.springcorddemo.rest;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "practice back stroke 35mins daily...";
    }
}
