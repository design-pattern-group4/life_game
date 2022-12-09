package com.holub;

import com.holub.life.Cell;
import com.holub.life.GridCellsize;
import com.holub.life.Neighborhood;
import com.holub.life.Resident;
import org.junit.jupiter.api.Test;
import java.awt.geom.Rectangle2D;
import java.beans.Transient;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapSizeTest {
    @Test
    public void EqualSingletonInstanceTest(){

        //given
        GridCellsize testsingleton = GridCellsize.getInstance();
        GridCellsize testsingleton2 = GridCellsize.getInstance();


        //when


        //then

        //1개의 instance만 생성하므로 같아야 한다.
        assertEquals(testsingleton,testsingleton2);

        //마찬가지로 1개의 instance만 생성하기 때문에, 마지막 2로 바뀐 값으로 같아야 한다.
        assertEquals(testsingleton.getGridSize(),testsingleton2.getGridSize());
        System.out.println(testsingleton.getGridSize());
        System.out.println(testsingleton2.getGridSize());

    }

    @Test
    public void changeMapSizeTest(){
        //given
        GridCellsize gridCellsize = GridCellsize.getInstance();
        int change = 2;
        Cell outermostCell = new Neighborhood(
                                new Neighborhood(
                                    new Resident()
                                )
                             );

        //when
        gridCellsize.changeGridSize(change);
        outermostCell.changeMap2();
        //가장 외곽 Cell 의 갯수, 즉 , 한 변의 길이.
        //System.out.println(outermostCell.widthInCells());
        //각 각의 grid를 하나의 사각형이라고 했을 때, 한 변의 길이가 cell의 갯수.
        //System.out.println(gridCellsize.getCellSize());
        // 따라서, 전체 cell의 개수는 map의 한변 길이 * 각 grid의 한변 길이 * 전체 grid 개수
        int totalCell = outermostCell.widthInCells() * gridCellsize.getCellSize() * gridCellsize.getGridSize();
        System.out.println(totalCell);

        //then
        // 2*2 일 때,
        assertEquals(256,totalCell);


        // 4*4 일 때,
        //when
        change = 4;
        gridCellsize.changeGridSize(change);
        outermostCell.changeMap2();
        totalCell = outermostCell.widthInCells() * gridCellsize.getCellSize() * gridCellsize.getGridSize();
        System.out.println(totalCell);
        //then
        assertEquals(1024,totalCell);

        //8*8 일 때,
        //when
        change = 8;
        gridCellsize.changeGridSize(change);
        outermostCell.changeMap2();
        totalCell = outermostCell.widthInCells() * gridCellsize.getCellSize() * gridCellsize.getGridSize();
        System.out.println(totalCell);
        //then
        assertEquals(4096,totalCell);



    }
}
