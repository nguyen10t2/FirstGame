package entity;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public abstract class Character {
    protected int health;
    protected int attack;
    protected int speed;
    protected double groundY;
    protected ImageView sprite;

    protected boolean moveLeft = false;
    protected boolean moveRight = false;
    protected boolean isJumping = false;

    protected double velocityY = 0;
    protected double velocityX = 0;

    protected final double gravity = 0.6;
    protected final double jumpSpeed = 12;
    protected double jumpTime = 0;

    protected AnimationTimer gameLoop;

    protected boolean keyPressedW = false;
    protected boolean keyPressedA = false;
    protected boolean keyPressedD = false;

    public Character() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateMovement();
                updatePosition(760);
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
                if (sprite.getScaleX() > 0) {
                    sprite.setScaleX(-1);
                }
            } else if (keyPressedD) {
                velocityX = speed * 0.5;
                if (sprite.getScaleX() < 0) {
                    sprite.setScaleX(1);
                }
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
            double newX = sprite.getLayoutX() + velocityX;
            sprite.setLayoutY(sprite.getLayoutY() + velocityY);
            sprite.setLayoutX(Math.min(boundary + sprite.getFitWidth(), Math.max(0, newX)));
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
