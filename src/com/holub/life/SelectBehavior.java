package com.holub.life;

import java.awt.*;

public class SelectBehavior implements KeyBoardBehavior {
    @Override
    public boolean isPressed(char pressedKey) {
        return pressedKey == 'k';
    }

    @Override
    public Point action(Cell outermostCell, Point cur, Point before, Rectangle bounds, int pixelsPerCell, boolean isFirst) {
        outermostCell.userClicked(cur, bounds);
        return cur;
    }
}
