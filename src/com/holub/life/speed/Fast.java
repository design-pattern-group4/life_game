package com.holub.life.speed;

import com.holub.ui.VisitorElement;
import com.holub.ui.VisitorInterface;

public class Fast implements Speed, VisitorElement {
    @Override
    public String getName() {
        return "Fast";
    }

    @Override
    public int getSpeed() {
        return 30;
    }

    @Override
    public String getMenuName() {
        return "Fast";
    }

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}
