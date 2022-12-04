package com.holub.keyboard;

import com.holub.life.Cell;

import java.awt.*;

public class MoveLeftBehavior implements KeyBoardBehavior {
    @Override
    public boolean isPressed(char pressedKey) {
        return pressedKey == 'a';
    }

    @Override
    public Point action(Cell outermostCell, Point cur, Point before, Rectangle bounds, int pixelsPerCell, boolean isFirst) {
        if (cur.x > 0) {
            cur.x -= pixelsPerCell;
        }
        outermostCell.userSelected(cur, bounds);
        if (before != null && !isFirst) {
            outermostCell.userSelected(before, bounds);
        }
        return cur;
    }
}
