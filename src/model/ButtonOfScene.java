package model;

public class ButtonOfScene {
    private SRButton button;
    private boolean isPressed = false;

    public ButtonOfScene(SRButton button) {
        this.button = button;
    }

    public boolean isButtonPressed() {
        button.setOnMouseClicked(e -> {
            isPressed = true;
            System.out.println("Button Clicked");
        });
        return isPressed;
    }

    public void setLayout(double x, double y) {
        button.setLayoutX(x);
        button.setLayoutY(y);
    }

    public SRButton getButton() {
        return button;
    }
}
