package com.holub;

import com.holub.life.GridCellsize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void EqualSingletonInstanceTest(){

        //given
        GridCellsize testsingleton = GridCellsize.getInstance();
        GridCellsize testsingleton2 = GridCellsize.getInstance();


        //when
        testsingleton.changeGridSize(4);
        testsingleton2.changeGridSize(2);

        //then

        //1개의 instance만 생성하므로 같아야 한다.
        assertEquals(testsingleton,testsingleton2);

        //마찬가지로 1개의 instance만 생성하기 때문에, 마지막 2로 바뀐 값으로 같아야 한다.
        assertEquals(testsingleton.getGridSize(),testsingleton2.getGridSize());
        System.out.println(testsingleton.getGridSize());
        System.out.println(testsingleton2.getGridSize());

    }

}