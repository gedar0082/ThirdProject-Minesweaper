package sample;


import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Controller {
    public static Polygon[][] buttons;
    public static Field field;
    public static void init() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                final int row = i;
                final int column = j;
                buttons[i][j].setOnMouseClicked(event -> {
                       //if(field.getCell(row,column).getMine());
                        field.clickCell(row, column);
                        Controller.refresh();
                });
            }
        }
    }

    public static void refresh() {
        for (int i =0; i < buttons.length; i++) {
            for(int j = 0; j< buttons[0].length; j++) {
                if (!field.getCell(i,j).getVisibility()) {
                    buttons[i][j].setFill(Color.GRAY);

                } else {
                    if (field.getCell(i,j).getNearestMines() == 0) {
                        buttons[i][j].setFill(Color.WHITE);
                    } else {
                        buttons[i][j].setFill(Color.BLACK);
                    }
                    if (field.getCell(i,j).getMine() == true) {
                        buttons[i][j].setFill(Color.YELLOW);
                    }

                }
            }
        }
    }
}
