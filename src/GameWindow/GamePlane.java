package GameWindow;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import Enum.Source;
import View.ViewManager;
import View.Exit;

public class GamePlane extends Application {
    private ViewManager viewManager = new ViewManager();
    private Exit exit = new Exit(viewManager.getMainStage());
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage = viewManager.getMainStage();
        primaryStage.getIcons().add(new Image("file:/" + Source.iconWindow));
        primaryStage.setTitle("BLUE KNIGHT");
        primaryStage.setResizable(false);
        Exit exit = new Exit(primaryStage);
        primaryStage.show();
        exit.exit(viewManager.getButtonOfScene());
    }

    public Stage getPrimaryStage() {
        return viewManager.getMainStage();
    }
    public static void main(String[] args) {
        System.out.println("Running...");
        launch(args);
    }
}
