package sample;

import java.util.ArrayList;

public class Cell {
    private Field field;
    private int mines;
    Cell(boolean mine, boolean visibility, boolean flag, Field field){
        this.mine = mine;
        mines = (int)(Math.random() * 10) % 7;
        if (mines > 6) mines = 0;
        this.field = field;
        this.visibility = visibility;
        this.flag = flag;
        this.field = field;
    }
    private boolean mine;
    private boolean visibility;
    private boolean flag;
    public int getMines() {
        return mines;
    }

    public boolean getVisibility(){
        return visibility;
    }

    public boolean getFlag(){
        return flag;
    }

    public boolean getMine(){
        return mine;
    }

    public void setVisile(){
        if(!visibility){
            visibility = true;
        }
    }

    public void setFlag(){
        if(!flag){
            flag = true;
        }
    }

    public void removeFlag(){
        if(flag){
            flag = false;
        }
    }

    private int[][] nearestCells = new int[6][2];
    public int[][] getNearestCells(int row, int column){
        if (row % 2 == 0){
            nearestCells[0][0] = row;
            nearestCells[0][1] = column - 1;
            nearestCells[1][0] = row -1;
            nearestCells[1][1] = column;
            nearestCells[2][0] = row - 1;
            nearestCells[2][1] = column + 1;
            nearestCells[3][0] = row;
            nearestCells[3][1] = column + 1;
            nearestCells[4][0] = row + 1;
            nearestCells[4][1] = column + 1;
            nearestCells[5][0] = row + 1;
            nearestCells[5][1] = column;
        }else{
            nearestCells[0][0] = row-1;
            nearestCells[0][1] = column;
            nearestCells[1][0] = row -1;
            nearestCells[1][1] = column - 1;
            nearestCells[2][0] = row - 1;
            nearestCells[2][1] = column;
            nearestCells[3][0] = row;
            nearestCells[3][1] = column + 1;
            nearestCells[4][0] = row + 1;
            nearestCells[4][1] = column;
            nearestCells[5][0] = row + 1;
            nearestCells[5][1] = column;
        }
        return nearestCells;
    }
}
