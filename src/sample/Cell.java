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


    public ArrayList<PareCords> nearestCells = new ArrayList<>();
    public ArrayList<PareCords> getNearestCells(int row, int column){
        for (int i = 0; i < 6; i ++ ){
            if (row % 2 == 0){

                if(column > 0) {
                    PareCords f = new PareCords(row, column - 1);
                    nearestCells.add(i, f);
                }

                if(row > 0){
                    PareCords f = new PareCords(row - 1, column);
                    nearestCells.add(i, f);
                }

                if(column < field.getSize() - 1 && row > 0){
                    PareCords f = new PareCords(row - 1, column + 1);
                    nearestCells.add(i, f);
                }

                if(column < field.getSize() - 1){
                    PareCords f = new PareCords(row, column + 1);
                    nearestCells.add(i, f);
                }

                if(column < field.getSize() - 1 && row < field.getSize() - 1){
                    PareCords f = new PareCords(row + 1, column + 1);
                    nearestCells.add(i, f);
                }

                if(row < field.getSize() - 1){
                    PareCords f = new PareCords(row + 1, column);
                    nearestCells.add(i, f);
                }

            }else{

                if(column > 0){
                    PareCords f = new PareCords(row, column - 1);
                    nearestCells.add(i, f);
                }

                if(row > 0){
                    PareCords f = new PareCords(row - 1, column);
                    nearestCells.add(i, f);
                }

                if(row > 0 && column < field.getSize() - 1){
                    PareCords f = new PareCords(row - 1, column + 1);
                    nearestCells.add(i, f);
                }

                if(column < field.getSize() - 1){
                    PareCords f = new PareCords(row, column + 1);
                    nearestCells.add(i, f);
                }

                if(row < field.getSize() - 1){
                    PareCords f = new PareCords(row + 1, column);
                    nearestCells.add(i, f);
                }

                if(row < field.getSize() - 1 && column > 0){
                    PareCords f = new PareCords(row + 1, column - 1);
                    nearestCells.add(i,f);
                }
            }

        }
        return nearestCells;
    }
}
