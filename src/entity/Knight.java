package entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import constants.Source;

public class Knight extends Character {
    public Knight() {
        int[] knight = Source.knightSize;
        this.setHealth(knight[0]);
        this.setAttack(knight[1]);
        this.setSpeed(knight[2]);
        this.setSprite(new ImageView(new Image("file:" + Source.yellowKnight)));
    }
}
