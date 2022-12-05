package com.holub.life;

public class GridCellsize {
    //static method에서 access되는 모든 variable은 static 이여야함. 안그러면 instance 만들때마다 생성됨.
    private static int  GRID_SIZE = 0;
    private static int  CELL_SIZE = 0 ;
    private volatile static GridCellsize uniqueInstance = null ;

    private GridCellsize(int GRID_SIZE, int CELL_SIZE){
        this.GRID_SIZE = GRID_SIZE;
        this.CELL_SIZE = CELL_SIZE;

    }


    public static GridCellsize getInstance(int grid_size, int cell_size) {
        if (uniqueInstance== null) {
            synchronized(GridCellsize.class) {
                if (uniqueInstance== null)
                    uniqueInstance= new GridCellsize(grid_size, cell_size);
            }
        }
        return uniqueInstance;
    }
    private void setGridSize(int GRID_SIZE){
        this.GRID_SIZE = GRID_SIZE;
    }
    private void setCellSize(int CELL_SIZE){
        this.CELL_SIZE = CELL_SIZE;

    }

    public int getGridSize(){
        return this.GRID_SIZE;

    }

    public int getCellSize(){
        return this.CELL_SIZE;

    }

//  => 변경할때마다 instance 새로 초기화 하는 방식.. 근데 그럴 필요 없는 것 같음. 방법 1
//    public static GridCellsize changeGridCellSize(int grid_size, int cell_size){
//        if(uniqueInstance != null){
//            uniqueInstance = null;
//        }
//        return getInstance(grid_size,cell_size);
//    }
// 맨 처음 만들어진 instance에 값 변경
    public void changeGridSize(int grid_size){
        setGridSize(grid_size);

    }


}

