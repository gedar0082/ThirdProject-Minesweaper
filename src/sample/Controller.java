package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Controller {
    public static Polygon[][] buttons;
    public static Field field;
    public static void init() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                final int row = i;
                final int column = j;
                buttons[i][j].setOnMouseClicked(event -> {
                    System.out.println("Clicked");
                    System.out.println(row);
                    System.out.println(column);
                        field.clickCell(row, column);
                        Controller.refresh();
                });
            }
        }
    }
    public static void refresh() {
        for (int i =0; i < buttons.length; i++) {
            for(int j = 0; j< buttons.length; j++) {
                if (!field.getCell(i,j).getVisibility()) {
                    buttons[i][j].setFill(Color.GRAY);
                } else {
                    if (field.getCell(i,j).getMines() == 0) {
                        buttons[i][j].setFill(Color.WHITE);
                    } else {
                        buttons[i][j].setFill(Color.BLACK);
                    }
                }
            }
        }
    }
}
