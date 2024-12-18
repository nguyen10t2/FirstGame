package GameWindow;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import Enum.Const;
import Enum.Source;

public class GamePlane extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        primaryStage.getIcons().add(new Image("file:\\" + Source.iconWindow));

        Scene scene = new Scene(root, Const.height.getValue(), Const.width.getValue());

        primaryStage.setTitle("BlackKnight");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        System.out.println("Running...");
        launch(args);
    }
}
