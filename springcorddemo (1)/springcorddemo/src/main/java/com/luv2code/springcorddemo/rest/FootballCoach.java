package com.luv2code.springcorddemo.rest;

public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "always come for training every weekend...";
    }
}
