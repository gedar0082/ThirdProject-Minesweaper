package sample;
import java.util.ArrayList;
public class Field {

    private int lenght;
    private int height;
    private boolean mine;
    private int mines;

    private Cell[][] field;
    Field(int height, int lenght){
        this.height = height;
        this.lenght = lenght;
        field = new Cell[height][lenght];
        for (int row = 0; row < height; row ++){
            for (int column = 0; column < lenght; column ++){
                int c = (int)(Math.random() * 7);
                if(c == 0) mine = true;
                else mine = false;
                    field[row][column] = new Cell(row, column, mine,false,false);
                    getNearestCells(row,column);

            }
        }
        Controller.field = this;
    }

    public int getLenght(){
        return lenght;
    }

    public int getHeight(){
        return height;
    }

    public int getNearestMines(int row, int column) {
        mines = 0;
        ArrayList<PareCords> array = getNearestCells(row, column);
        for(int i = 0; i < array.size(); i++) {
            if (field[array.get(i).getY()][array.get(i).getX()].getMine()){
                mines++;
            }
        }
        return mines;
    }


    private ArrayList<PareCords> getNearestCells(int row, int column){
        ArrayList<PareCords> nearestCells = new ArrayList<>();
        nearestCells.clear();
        if (row % 2 == 0){
            if(row < getHeight() - 2) {
                PareCords f = new PareCords(row + 2, column);
                nearestCells.add(f);
            }

            if(row < getHeight() - 1){
                PareCords f = new PareCords(row + 1, column);
                nearestCells.add(f);

            }

            if(row < getHeight() - 1 && column > 0){
                PareCords f = new PareCords(row + 1, column - 1);
                nearestCells.add(f);

            }

            if(row > 0 && column > 0){
                PareCords f = new PareCords(row - 1, column - 1);
                nearestCells.add(f);

            }

            if(row > 0){
                PareCords f = new PareCords(row - 1, column);
                nearestCells.add(f);

            }

            if(row > 1){
                PareCords f = new PareCords(row - 2, column);
                nearestCells.add(f);

            }

        }else {

            if (row < getHeight() - 2) {
                PareCords f = new PareCords(row + 2, column);
                nearestCells.add(f);

            }

            if (row < getHeight() - 1) {
                PareCords f = new PareCords(row + 1, column);
                nearestCells.add(f);

            }

            if (row < getHeight() - 1 && column < getLenght() - 1) {
                PareCords f = new PareCords(row + 1, column + 1);
                nearestCells.add(f);

            }

            if (row > 0 && column < getLenght() - 1) {
                PareCords f = new PareCords(row - 1, column + 1);
                nearestCells.add(f);

            }

            if (row > 0) {
                PareCords f = new PareCords(row - 1, column);
                nearestCells.add(f);
            }

            if (row > 1) {
                PareCords f = new PareCords(row - 2, column);
                nearestCells.add(f);
            }
        }
        return nearestCells;

    }

    public void clickCell(int row, int column){
        ArrayList<PareCords> nearest = getNearestCells(row, column);
        if(field[row][column].getMine()){
            System.exit(0);
        }
        if(getNearestMines(row, column) != 0 || field[row][column].getVisibility() || field[row][column].getMine()){
            field[row][column].setVisible();
            return;
        } else {
            field[row][column].setVisible();
            for (int i = 0; i < nearest.size(); i++) {
                clickCell(nearest.get(i).getY(), nearest.get(i).getX());

            }

        }

    }

    public Cell getCell(int row, int column) {
        return field[row][column];
    }



}
