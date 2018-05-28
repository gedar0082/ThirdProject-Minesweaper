package sample;
import java.util.ArrayList;
public class Field {

    private int lenght;
    private int height;
    private boolean mine;

    protected Cell[][] field;
    Field(int height, int lenght){
        this.height = height;
        this.lenght = lenght;
        field = new Cell[height][lenght];
        for (int row = 0; row < height; row ++){
            for (int column = 0; column < lenght; column ++){
                int c = (int)(Math.random() * 8);
                if(c == 0) mine = true;
                else mine = false;
                    field[row][column] = new Cell(mine,false,false, this);
                    field[row][column].getNearestCells(row,column);
            }
        }
        Controller.field=this;
    }

    public int getLenght(){
        return lenght;
    }

    public int getHeight(){
        return height;
    }
    public void clickCell(int row, int column) {
        field[row][column].setVisible();
        ArrayList<PareCords> nearest = field[row][column].getNearestCells(row,column);
        for (int i = 0; i < nearest.size(); i++) {
            field[nearest.get(i).getY()][nearest.get(i).getX()].setVisible();
            System.out.println(field[row][column].getNearestMines());
            field[row][column].nullMines();
            if (field[row][column].getNearestMines() == 0 && !field[row][column].getVisibility()) {
                field[row][column].setVisible();
                clickCell(nearest.get(i).getY(), nearest.get(i).getX());
            }
        }
    }
    public Cell getCell(int row, int column) {
        return field[row][column];
    }



}
