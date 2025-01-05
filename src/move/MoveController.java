package move;

import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.Node;

public class MoveController<T extends Node> {
    private Scene scene;
    private Pane root;
    private T entity;

    public MoveController(Scene scene, Pane root, T entity) {
        this.scene = scene;
        this.root = root;
        this.entity = entity;
        root.getChildren().add(entity);
    }

    private void updatePosition(ImageView sprite, double speed) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case A: sprite.setLayoutX(sprite.getLayoutX() - speed); break;
                case D: sprite.setLayoutX(sprite.getLayoutX() + speed); break;
            }
        });
    }
}
