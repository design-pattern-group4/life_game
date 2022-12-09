package com.holub.life.speed;

import com.holub.ui.VisitorElement;
import com.holub.ui.VisitorInterface;

public class Halt implements Speed, VisitorElement {
    @Override
    public String getName() {
        return "Halt";
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public String getMenuName() {
        return "Halt";
    }

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}
