package com.holub.keyboard;

import com.holub.life.Cell;

import java.awt.*;

public interface KeyBoardBehavior {
    boolean isPressed(char pressedKey);
    Point action(Cell outermostCell, Point cur, Point before, Rectangle bounds, int pixelsPerCell, boolean isFirst);
}
