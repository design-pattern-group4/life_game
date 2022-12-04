package com.holub.keyboard;

import com.holub.life.Cell;

import java.awt.*;

public class MoveDownBehavior implements KeyBoardBehavior {
    @Override
    public boolean isPressed(char pressedKey) {
        return pressedKey == 's';
    }

    @Override
    public Point action(Cell outermostCell, Point cur, Point before, Rectangle bounds, int pixelsPerCell, boolean isFirst) {
        if (cur.y + pixelsPerCell < bounds.height) {
            cur.y += pixelsPerCell;
        }
        outermostCell.userSelected(cur, bounds);
        if (before != null && !isFirst) {
            outermostCell.userSelected(before, bounds);
        }
        return cur;
    }
}
