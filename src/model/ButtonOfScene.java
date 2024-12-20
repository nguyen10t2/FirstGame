package model;

import Enum.Const;

public class ButtonOfScene {
    private SRButton button;
    private boolean isPressed = false;

    public ButtonOfScene(SRButton button) {
        this.button = button;
        button.setLayoutX(Const.width.getValue() / 2 - button.getPrefWidth() / 2);
        button.setLayoutY(Const.height.getValue() / 2 - button.getPrefHeight() / 2);
    }

    public boolean isButtonPressed() {
        button.setOnMouseClicked(e -> {
            isPressed = true;
            System.out.println("Button Clicked");
        });
        return isPressed;
    }

    public SRButton getButton() {
        return button;
    }
}
