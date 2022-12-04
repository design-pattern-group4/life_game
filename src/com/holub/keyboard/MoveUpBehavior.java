package com.holub.keyboard;

import com.holub.life.Cell;

import java.awt.*;

public class MoveUpBehavior implements KeyBoardBehavior {
    @Override
    public boolean isPressed(char pressedKey) {
        return pressedKey == 'w';
    }

    @Override
    public Point action(Cell outermostCell, Point cur, Point before, Rectangle bounds, int pixelsPerCell, boolean isFirst) {
        if (cur.y > 0) {
            cur.y -= pixelsPerCell;
        }
        outermostCell.userSelected(cur, bounds);
        if (before != null && !isFirst) {
            outermostCell.userSelected(before, bounds);
        }
        return cur;
    }
}
