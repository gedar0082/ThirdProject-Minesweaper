package sample;

import java.util.ArrayList;

public class Cell {
    private Field field;
    private int mines;
    Cell(boolean mine, boolean visibility, boolean flag, Field field){
        this.mine = mine;
        this.visibility = visibility;
        this.flag = flag;
        this.field = field;
    }

    private boolean mine;
    private boolean visibility;
    private boolean flag;
    public int getNearestMines() {
        for(int i = 0; i < nearestCells.size(); i++) {
            if (field.getCell(nearestCells.get(i).getY(), nearestCells.get(i).getX()).getMine()){
                mines++;
            }
        }
        return mines;
    }
    public void nullMines(){
        mines = 0;
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

    public void setVisible(){
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

                if(row < field.getHeight() - 2) {
                    PareCords f = new PareCords(row + 2, column);
                    nearestCells.add(i, f);
                }

                if(row < field.getHeight() - 1){
                    PareCords f = new PareCords(row + 1, column);
                    nearestCells.add(i, f);
                }

                if(row < field.getHeight() - 1 && column > 0){
                    PareCords f = new PareCords(row + 1, column - 1);
                    nearestCells.add(i, f);
                }

                if(row > 0 && column > 0){
                    PareCords f = new PareCords(row - 1, column - 1);
                    nearestCells.add(i, f);
                }

                if(row > 0){
                    PareCords f = new PareCords(row - 1, column);
                    nearestCells.add(i, f);
                }

                if(row > 1){
                    PareCords f = new PareCords(row - 2, column);
                    nearestCells.add(i, f);
                }

            }else{

                if(row < field.getHeight() - 2) {
                    PareCords f = new PareCords(row + 2, column);
                    nearestCells.add(i, f);
                }

                if(row < field.getHeight() - 1){
                    PareCords f = new PareCords(row + 1, column);
                    nearestCells.add(i, f);
                }

                if(row < field.getHeight() - 1 && column < field.getLenght() - 1){
                    PareCords f = new PareCords(row + 1, column + 1);
                    nearestCells.add(i, f);
                }

                if(row > 0 && column < field.getLenght() - 1){
                    PareCords f = new PareCords(row - 1, column + 1);
                    nearestCells.add(i, f);
                }

                if(row > 0){
                    PareCords f = new PareCords(row - 1, column);
                    nearestCells.add(i, f);
                }

                if(row > 1){
                    PareCords f = new PareCords(row - 2, column);
                    nearestCells.add(i, f);
                }
            }

        }
        return nearestCells;
    }
}
