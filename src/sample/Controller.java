package sample;


import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Controller {
    public static Polygon[][] buttons;
    public static Field field;
    private static final String img1 = "file:1.png";
    private static final String img2 = "file:2.png";
    private static final String img3 = "file:3.png";
    private static final String img4 = "file:4.png";
    private static final String img5 = "file:5.png";
    private static final String img6 = "file:6.png";
    private static final String flag = "file:flag.png";
    private static final String bomb = "file:bomb.png";

    public static void init() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                final int row = i;
                final int column = j;


                buttons[i][j].setOnMouseClicked(mouseEvent -> {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY){
                        field.clickCell(row, column);
                        Controller.refresh();
                    }

                    if (mouseEvent.getButton() == MouseButton.SECONDARY){
                        field.getCell(row,column).setFlag();
                        Controller.refresh();
                    }
                });



            }
        }
    }

    public static void refresh() {
        for (int i =0; i < buttons.length; i++) {
            for(int j = 0; j< buttons[0].length; j++) {
                if (!field.getCell(i,j).getVisibility()) {
                    buttons[i][j].setFill(Color.ORANGE);
                    if(field.getCell(i,j).getFlag()){
                        buttons[i][j].setFill(new ImagePattern(new Image(flag)));
                    }

                } else {
                    if (field.getCell(i,j).getNearestMines() == 0) {
                        buttons[i][j].setFill(Color.WHITE);
                    }
                    if (field.getCell(i,j).getNearestMines() == 1) {
                        buttons[i][j].setFill(new ImagePattern(new Image(img1)));
                    }
                    if (field.getCell(i,j).getNearestMines() == 2) {
                        buttons[i][j].setFill(new ImagePattern(new Image(img2)));
                    }
                    if (field.getCell(i,j).getNearestMines() == 3) {
                        buttons[i][j].setFill(new ImagePattern(new Image(img3)));
                    }
                    if (field.getCell(i,j).getNearestMines() == 4) {
                        buttons[i][j].setFill(new ImagePattern(new Image(img4)));
                    }
                    if (field.getCell(i,j).getNearestMines() == 5) {
                        buttons[i][j].setFill(new ImagePattern(new Image(img5)));
                    }
                    if (field.getCell(i,j).getNearestMines() == 6) {
                        buttons[i][j].setFill(new ImagePattern(new Image(img6)));
                    }

                    if (field.getCell(i,j).getMine()) {
                        buttons[i][j].setFill(new ImagePattern(new Image(bomb)));
                    }



                }
            }
        }
    }
}
