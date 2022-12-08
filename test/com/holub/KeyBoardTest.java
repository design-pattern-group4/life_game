package com.holub;

import com.holub.keyboard.KeyBoardBehavior;
import com.holub.life.Cell;
import com.holub.life.SampleLife;
import com.holub.life.Universe;
import org.junit.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class KeyBoardTest {

//    @Test
//    public void moveTest(){
//
//    }

    @Test
    public void moveTest(){

        //given
        new SampleLife();
        Universe universe = Universe.instance();
        Cell outermostCell = universe.getOutermostCell();
        Point cur = universe.getCur();
        Point before = universe.getBefore();
        int DEFAULT_GRID_SIZE = universe.getDefaultGridSize();
        int DEFAULT_CELL_SIZE = universe.getDefaultCellSize();
        boolean isFirst = universe.getIsFirst();
        Rectangle bounds = universe.getBounds();
        bounds.x = 0;
        bounds.y = 0;
        int pixelsPerCell = (bounds.width / DEFAULT_GRID_SIZE) / DEFAULT_GRID_SIZE;

        int curX = 0;
        int curY = 0;

        //when#1 우로 이동
        int move = 1;
        KeyBoardBehavior keyBoardBehavior = universe.getKeyBoardStrategy('d');

        //then#1
        for (; move < DEFAULT_CELL_SIZE * DEFAULT_GRID_SIZE; move++) {
            keyBoardBehavior.action(outermostCell, cur, before, bounds, pixelsPerCell, isFirst);
            curX += pixelsPerCell;
            assertEquals(cur.x, curX);
        }

        //when#2 좌로 이동
        move = 1;
        keyBoardBehavior = universe.getKeyBoardStrategy('a');

        //then#2
        for (; move < DEFAULT_CELL_SIZE * DEFAULT_GRID_SIZE; move++) {
            keyBoardBehavior.action(outermostCell, cur, before, bounds, pixelsPerCell, isFirst);
            curX -= pixelsPerCell;
            assertEquals(cur.x, curX);
        }

        //when#3 아래로 이동
        move = 1;
        keyBoardBehavior = universe.getKeyBoardStrategy('s');

        //then#3
        for (; move < DEFAULT_CELL_SIZE * DEFAULT_GRID_SIZE; move++) {
            keyBoardBehavior.action(outermostCell, cur, before, bounds, pixelsPerCell, isFirst);
            curY += pixelsPerCell;
            assertEquals(cur.y, curY);
        }

        //when#4 위로 이동
        move = 1;
        keyBoardBehavior = universe.getKeyBoardStrategy('w');

        //then#4
        for (; move < DEFAULT_CELL_SIZE * DEFAULT_GRID_SIZE; move++) {
            keyBoardBehavior.action(outermostCell, cur, before, bounds, pixelsPerCell, isFirst);
            curY -= pixelsPerCell;
            assertEquals(cur.y, curY);
        }
    }
}