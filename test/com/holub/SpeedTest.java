package com.holub;

import com.holub.life.speed.ControlSpeed;
import com.holub.life.speed.QuiteSlow;
import com.holub.life.speed.Speed;
import com.holub.life.speed.VeryFast;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeedTest {

    @Test
    public void speedController(){

        // given
        Speed verySlow = new QuiteSlow();
        Speed veryFast = new VeryFast();
        ControlSpeed cs1 = ControlSpeed.getInstance();
        ControlSpeed cs2 = ControlSpeed.getInstance();

        // when
        cs1.setSpeed(verySlow);
        cs2.setSpeed(veryFast);

        // then
        assertEquals(cs1.getSpeed(), cs2.getSpeed());
    }
}