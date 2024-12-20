package model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class SRButton extends Button {
	private final String BUTTON_PRESSED_STYLE;
    private final String BUTTON_FREE_STYLE;
    private final String BUTTON_HOVER_STYLE;

	public SRButton(String buttonPressedStyle, String buttonFreeStyle, String buttonHoverStyle) {
		this.BUTTON_PRESSED_STYLE = buttonPressedStyle;
        this.BUTTON_FREE_STYLE = buttonFreeStyle;
        this.BUTTON_HOVER_STYLE = buttonHoverStyle;
        setLayout(46, 110);
        setTextFill("EXIT");
        initallizeButton();
        this.textFillProperty().set(javafx.scene.paint.Color.WHITE);
	}

    private void setLayout(double x, double y) {
        setPrefHeight(x);
        setPrefWidth(y);
    }

    private void setTextFill(String text) {
        setText(text);
        setStyle(BUTTON_FREE_STYLE);
    }

    private void setButtonPressedStyle() {
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(46);
        setLayoutY(getLayoutY());
    }

    private void setButtonReleaseStyle() {
        setStyle(BUTTON_FREE_STYLE);
        setPrefWidth(110);
        setLayoutY(getLayoutY());
    }

    private void setButtonHoverStyle() {
        setStyle(BUTTON_HOVER_STYLE);
        setEffect(new DropShadow());
    }

    private void initallizeButton() {
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().name().equals("PRIMARY")) {
                    setButtonPressedStyle();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().name().equals("PRIMARY")) {
                    setButtonReleaseStyle();
                }
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setButtonHoverStyle();
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setButtonReleaseStyle();
                setEffect(null);
            }
        });
    }
}
