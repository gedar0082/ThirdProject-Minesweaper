package sample;
import java.util.ArrayList;
import java.util.Random;

public class Field {

    private int size;

    final Random random = new Random();

    protected Cell[][] field;
    Field(int size){
        this.size = size;
        field = new Cell[size][size];
        for (int row = 0; row < size; row ++){
            for (int column = 0; column < size; column ++){
                boolean mine =random.nextBoolean();
                    field[row][column] = new Cell(mine,false,false, this);
                    field[row][column].getNearestCells(row,column);
            }
        }
        Controller.field=this;
    }

    public int getSize(){
        return size;
    }
    public void clickCell(int row, int column) {
        field[row][column].setVisile();
        ArrayList<PareCords> nearest = field[row][column].getNearestCells(row,column);
        int countOpened = 0;
        for (int i = 0; i < nearest.size(); i++) {
            if (field[row][column].getMines() == 0) {
                clickCell(nearest.get(i).getY(), nearest.get(i).getX());
                System.out.println(nearest.get(i).getY());
                System.out.println(nearest.get(i).getX());
            }
        }
    }
    public Cell getCell(int row, int column) {
        return field[row][column];
    }



}
