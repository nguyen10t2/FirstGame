package View;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.ButtonOfScene;

public class Exit {
    private Stage mainStage;

    public Exit(Stage mainStage) {
        this.mainStage = mainStage;
        
    }

    public void exit(ButtonOfScene buttonOfScene) {
        Button button = buttonOfScene.getButton();
        button.setOnAction(e -> {
            if(buttonOfScene.isButtonPressed()) {
                mainStage.close();
            }
        });
    }
}
