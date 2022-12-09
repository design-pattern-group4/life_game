package com.holub.life.speed;

import com.holub.ui.VisitorElement;
import com.holub.ui.VisitorInterface;

public class Agonizing implements Speed, VisitorElement {
    @Override
    public String getName() {
        return "Agonizing";
    }

    @Override
    public int getSpeed() {
        return 500;
    }
    @Override
    public String getMenuName() {
        return "Agonizing";
    }

    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}
