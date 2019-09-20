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
        setSelected(rgbValuesMatchColoredRadioButton());
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

        pm.redProperty().addListener((observable, oldValue, newValue) -> setSelected(rgbValuesMatchColoredRadioButton()));
        pm.greenProperty().addListener((observable, oldValue, newValue) -> setSelected(rgbValuesMatchColoredRadioButton()));
        pm.blueProperty().addListener((observable, oldValue, newValue) -> setSelected(rgbValuesMatchColoredRadioButton()));
    }

    private boolean rgbValuesMatchColoredRadioButton() {
        return pm.getRed() == red && pm.getGreen() == green && pm.getBlue() == blue;
    }
}
