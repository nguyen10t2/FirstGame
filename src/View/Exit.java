package view;

import javafx.stage.Stage;
import model.ButtonOfScene;
import javafx.scene.control.Button;

public class Exit {
    private Stage mainStage;

    public Exit(Stage mainStage) {
        this.mainStage = mainStage;
        
    }

    public void exit(ButtonOfScene buttonOfScene) {
        Button button = buttonOfScene.getButton();
        button.setOnMouseClicked(e -> {
            buttonOfScene.isButtonPressed();
            mainStage.close();
        });
    }
}
