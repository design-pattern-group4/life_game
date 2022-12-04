package com.holub.life;

import java.awt.*;

public interface KeyBoardBehavior {
    boolean isPressed(char pressedKey);
    Point action(Cell outermostCell, Point cur, Point before, Rectangle bounds, int pixelsPerCell, boolean isFirst);
}
