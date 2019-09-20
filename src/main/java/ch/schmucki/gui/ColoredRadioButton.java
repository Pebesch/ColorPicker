package ch.schmucki.gui;

import ch.schmucki.presentationmodel.ColorPickerPM;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventType;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColoredRadioButton extends RadioButton {
    private ColorPickerPM pm;
    private int red, green, blue;

    public ColoredRadioButton(String colorName, ColorPickerPM pm, int red, int green, int blue) {
        super(colorName);
        this.setTextFill(Color.rgb(red, green, blue));
        this.pm = pm;
        this.red = red;
        this.green = green;
        this.blue = blue;
        setupValueChangedListeners();
    }

    private void setupValueChangedListeners() {
        this.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    pm.setRed(red);
                    pm.setGreen(green);
                    pm.setBlue(blue);
                }
            }
        });
    }
}
