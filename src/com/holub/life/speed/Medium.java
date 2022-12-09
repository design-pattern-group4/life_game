package com.holub.life.speed;

import com.holub.ui.VisitorElement;
import com.holub.ui.VisitorInterface;

public class Medium implements Speed, VisitorElement {
    @Override
    public String getName() {
        return "Medium";
    }

    @Override
    public int getSpeed() {
        return 70;
    }
    @Override
    public String getMenuName() {
        return "Medium";
    }

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}
