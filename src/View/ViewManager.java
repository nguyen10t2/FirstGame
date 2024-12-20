package View;

import Enum.Const;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ButtonOfScene;
import model.SRBlackButton;

public class ViewManager {
    private static final int height = Const.height.getValue();
    private static final int width = Const.width.getValue();
    private Pane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private ButtonOfScene buttonOfScene;

    public ViewManager() {
        mainPane = new Pane();
        mainScene = new Scene(mainPane, width, height);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        buttonOfScene = createButton();
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public Pane getMainPane() {
        return mainPane;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public ButtonOfScene getButtonOfScene() {
        return buttonOfScene;
    }

    private ButtonOfScene createButton() {
        ButtonOfScene buttonOfScene = new ButtonOfScene(new SRBlackButton());
        buttonOfScene.setLayout((int) (width - buttonOfScene.getButton().getPrefWidth()), 0);
        mainPane.getChildren().add(buttonOfScene.getButton());
        return buttonOfScene;
    }
}
