package com.holub.life.speed;

public class Slow implements Speed{
    @Override
    public String getName() {
        return "Slow";
    }

    @Override
    public int getSpeed() {
        return 150;
    }
}
