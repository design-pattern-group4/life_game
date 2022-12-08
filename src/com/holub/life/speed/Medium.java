package com.holub.life.speed;

public class Medium implements Speed{
    @Override
    public String getName() {
        return "Medium";
    }

    @Override
    public int getSpeed() {
        return 70;
    }
}
