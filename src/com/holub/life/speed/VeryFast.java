package com.holub.life.speed;

import com.holub.ui.VisitorElement;
import com.holub.ui.VisitorInterface;

public class VeryFast implements Speed, VisitorElement {
    @Override
    public String getName() {
        return "VeryFast";
    }

    @Override
    public int getSpeed() {
        return 10;
    }
    @Override
    public String getMenuName() {
        return "VeryFast";
    }

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}
