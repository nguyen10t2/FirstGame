package entity;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class Character {
    private int health;
    private int attack;
    private int speed;
    private double groundY;
    private ImageView sprite;

    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean isJumping = false;

    private double velocityY = 0;
    private double velocityX = 0;

    private final double gravity = 0.6;
    private final double jumpSpeed = 12;
    private double jumpTime = 0;

    private AnimationTimer gameLoop;

    private boolean keyPressedW = false;
    private boolean keyPressedA = false;
    private boolean keyPressedD = false;

    public Character() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateMovement();
                updatePosition(800);
            }
        };
        gameLoop.start();
    }

    public void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case W -> keyPressedW = true;
            case A -> keyPressedA = true;
            case D -> keyPressedD = true;
            default -> {
            }
        }
    }

    public void handleKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case A -> keyPressedA = false;
            case D -> keyPressedD = false;
            case W -> keyPressedW = false;
            default -> {
            }
        }
    }

    protected void startJump() {
        if (!isJumping) {
            isJumping = true;
            velocityY = -jumpSpeed;
            jumpTime = 0;
            if (keyPressedA) {
                velocityX = -speed * 0.5;
            } else if (keyPressedD) {
                velocityX = speed * 0.5;
            }
        }
    }

    protected void updateMovement() {
        if (keyPressedW) {
            startJump();
        }
        if (keyPressedA) {
            moveLeft = true;
            moveRight = false;
        } else if (keyPressedD) {
            moveLeft = false;
            moveRight = true;
        } else {
            moveLeft = false;
            moveRight = false;
        }
    }

    protected void updatePosition(double boundary) {
        if (isJumping) {
            sprite.setLayoutY(sprite.getLayoutY() + velocityY);
            sprite.setLayoutX(sprite.getLayoutX() + velocityX);
            jumpTime += 0.01;
            velocityY += gravity;
            if (sprite.getLayoutY() >= groundY) {
                sprite.setLayoutY(groundY);
                isJumping = false;
                velocityY = 0;
                velocityX = 0;
            }
        } else {
            if (moveLeft) {
                double newX = sprite.getLayoutX() - speed;
                sprite.setLayoutX(Math.max(0, newX));
                if (sprite.getScaleX() > 0) {
                    sprite.setScaleX(-1);
                }
            }
            if (moveRight) {
                double newX = sprite.getLayoutX() + speed;
                sprite.setLayoutX(Math.min(boundary + sprite.getFitWidth(), newX));
                if (sprite.getScaleX() < 0) {
                    sprite.setScaleX(1);
                }
            }
        }
    }

    public void stopGameLoop() {
        if (gameLoop != null) {
            gameLoop.stop();
        }
    }

    public void setGroundY(double groundY) {
        this.groundY = groundY;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
        this.sprite.setFitWidth(128);
        this.sprite.setFitHeight(128);
    }
 

    public ImageView getSprite() {
        return sprite;
    }
}
