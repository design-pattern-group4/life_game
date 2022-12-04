package com.holub.keyboard;

import com.holub.life.Cell;

import java.awt.*;

public class MoveRightBehavior implements KeyBoardBehavior {
    @Override
    public boolean isPressed(char pressedKey) {
        return pressedKey == 'd';
    }

    @Override
    public Point action(Cell outermostCell, Point cur, Point before, Rectangle bounds, int pixelsPerCell, boolean isFirst) {
        if (cur.x + pixelsPerCell < bounds.width) {
            cur.x += pixelsPerCell;
        }
        outermostCell.userSelected(new Point(cur.x, cur.y), bounds);
        if (before != null && !isFirst) {
            outermostCell.userSelected(before, bounds);
        }
        return cur;
    }
}
