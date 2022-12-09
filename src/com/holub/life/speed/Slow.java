package com.holub.life.speed;

import com.holub.ui.VisitorElement;
import com.holub.ui.VisitorInterface;

public class Slow implements Speed, VisitorElement {
    @Override
    public String getName() {
        return "Slow";
    }

    @Override
    public int getSpeed() {
        return 150;
    }
    @Override
    public String getMenuName() {
        return "Slow";
    }

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}
