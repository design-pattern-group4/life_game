package com.holub.life.speed;

public class VeryFast implements Speed{
    @Override
    public String getName() {
        return "VeryFast";
    }

    @Override
    public int getSpeed() {
        return 10;
    }
}
