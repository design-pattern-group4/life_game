package com.holub;

import com.holub.keyboard.KeyBoardBehavior;
import com.holub.life.Cell;
import com.holub.life.SampleLife;
import com.holub.life.Universe;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class KeyBoardTest {
    private static boolean isInitialized = false;
    Universe universe;
    Cell outermostCell;
    Point cur;
    Point before;
    int DEFAULT_GRID_SIZE;
    int DEFAULT_CELL_SIZE;
    boolean isFirst;
    Rectangle bounds;
    @Before
    public void setUp() throws Exception {
        if (!isInitialized) {
            System.out.println("setup");

            new SampleLife();
        }
        universe = Universe.instance();
        outermostCell = universe.getOutermostCell();
        cur = universe.getCur();
        before = universe.getBefore();
        DEFAULT_GRID_SIZE = universe.getDefaultGridSize();
        DEFAULT_CELL_SIZE = universe.getDefaultCellSize();
        isFirst = universe.getIsFirst();
        bounds = universe.getBounds();
        bounds.x = 0;
        bounds.y = 0;
        isInitialized = true;
    }

    @Test
    public void clickTest() {
        //given
        int pixelsPerCell = (bounds.width / DEFAULT_GRID_SIZE) / DEFAULT_GRID_SIZE;
        Cell[][] grid = outermostCell.getGrid();

        int row = cur.y / pixelsPerCell;
        int col = cur.x / pixelsPerCell;

        //when#1 클릭 한번
        KeyBoardBehavior keyBoardBehavior = universe.getKeyBoardStrategy('k');
        keyBoardBehavior.action(outermostCell, cur, before, bounds, pixelsPerCell, isFirst);
        //then#1
        assertTrue(grid[row][col].isAmActive(row, col));

        //when#2 클릭 한번 더
        keyBoardBehavior.action(outermostCell, cur, before, bounds, pixelsPerCell, isFirst);
        //then#2
        assertFalse(grid[row][col].isAmActive(row, col));
    }

    @Test
    public void moveTest(){

        //given
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