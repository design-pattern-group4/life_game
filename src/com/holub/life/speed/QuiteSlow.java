package com.holub.life.speed;

public class QuiteSlow implements Speed{
    @Override
    public String getName() {
        return "QuiteSlow";
    }

    @Override
    public int getSpeed() {
        return 1000;
    }
}
