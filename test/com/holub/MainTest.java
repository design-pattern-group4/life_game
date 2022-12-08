package com.holub;

import com.holub.life.Clock;
import com.holub.life.speed.ControlSpeed;
import com.holub.life.speed.QuiteSlow;
import com.holub.life.speed.Speed;
import com.holub.life.speed.VeryFast;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void add(){
        // given
        Speed verySlow = new QuiteSlow();
        Speed veryFast = new VeryFast();
        ControlSpeed cs1 = ControlSpeed.getInstance();
        ControlSpeed cs2 = ControlSpeed.getInstance();

        //ControlSpeed cd = new ControlSpeed();
        //ControlSpeed.getInstance().settingSpeed(verySlow);

        // when
        cs1.settingSpeed(verySlow);
        cs2.settingSpeed(veryFast);

        // then
        assertEquals(cs1.getSpeed(), cs2.getSpeed());

        //
    }
}