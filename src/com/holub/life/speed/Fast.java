package com.holub.life.speed;

public class Fast implements Speed{
    @Override
    public String getName() {
        return "Fast";
    }

    @Override
    public int getSpeed() {
        return 30;
    }
}
