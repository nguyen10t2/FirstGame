package view;

import constants.Const;
import entity.Knight;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.ButtonOfScene;
import model.SRYellowButton;
import javafx.scene.image.Image;
import constants.Source;

public class ViewManager {
    private static final int height = Const.height.getValue();
    private static final int width = Const.width.getValue();
    private Pane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private ButtonOfScene buttonOfScene;
    private Knight knight;

    public ViewManager() {
        mainPane = new Pane();
        mainScene = new Scene(mainPane, width, height);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        buttonOfScene = createButton();
        knight = createKnight();
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

    public Knight getKnight() {
        return knight;
    }

    private ButtonOfScene createButton() {
        ButtonOfScene buttonOfScene = new ButtonOfScene(new SRYellowButton());
        buttonOfScene.setLayout(width - buttonOfScene.getButton().getPrefWidth(), 0);
        mainPane.getChildren().add(buttonOfScene.getButton());
        return buttonOfScene;
    }

    private Knight createKnight() {
        Knight knight = new Knight(Source.knightSize, new Image("file:" + Source.yellowKnight));
        knight.getSprite().setLayoutX(width / 2 - knight.getSprite().getFitWidth() / 2);
        knight.getSprite().setLayoutY(height - knight.getSprite().getFitHeight() - 100);
        knight.setGroundY(knight.getSprite().getLayoutY());
        mainPane.getChildren().add(knight.getSprite());
        mainScene.setOnKeyPressed(knight::handleKeyPressed);
        mainScene.setOnKeyReleased(knight::handleKeyReleased);
        return knight;
    }
}
