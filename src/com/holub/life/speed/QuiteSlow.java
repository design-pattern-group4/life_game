package com.holub.life.speed;

import com.holub.ui.VisitorElement;
import com.holub.ui.VisitorInterface;

public class QuiteSlow implements Speed, VisitorElement {
    @Override
    public String getName() {
        return "QuiteSlow";
    }

    @Override
    public int getSpeed() {
        return 1000;
    }
    @Override
    public String getMenuName() {
        return "QuiteSlow";
    }

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}
