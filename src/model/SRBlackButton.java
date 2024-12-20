package model;



public class SRBlackButton extends SRButton {
    public SRBlackButton() {
        super("-fx-background-color: transparent; -fx-background-image: url('/model/resources/BlackButtonPressed.png');",
                "-fx-background-color: transparent; -fx-background-image: url('/model/resources/BlackButton.png');",
                "-fx-background-color: transparent; -fx-background-image: url('/model/resources/BlackButton.png'); -fx-cursor: hand;");
    }
}