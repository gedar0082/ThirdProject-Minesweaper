package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    final static int height = 30;
    final static int lenght = 10;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("Miner");
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
        Polygon[][] buttons = new Polygon[height][lenght];
        Field field = new Field(height, lenght);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < lenght; j++) {
                if (i % 2 == 0) {
                    buttons[i][j] = drawGex(20+60*j,17 + 17*i,20);
                    buttons[i][j].setFill(Color.DEEPPINK);
                    root.getChildren().add(buttons[i][j]);

                } else {
                    buttons[i][j] = drawGex(50 + 60*j, 17 + 17 * i, 20);
                    buttons[i][j].setFill(Color.PURPLE);
                    root.getChildren().add(buttons[i][j]);
                }
            }
        }

        Controller.buttons = buttons;
        Controller.init();
    }


    public static void main(String[] args) {
        launch(args);

    }
    public Polygon drawGex(double x,double y, int r) {
        return new Polygon(
                x-r,y,
                x-r/2, y-r*0.85,
                x+r/2, y-r*0.85,
                x+r, y,
                x+r/2, y+r*0.85,
                x-r/2, y+r*0.85
        );
    }
}
