package ch.schmucki.gui;

import ch.schmucki.exceptions.RGBFormatException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

public class ColorLane extends HBox {
    private IntegerProperty color;
    private String colorName;
    private Label colorLabel;
    private Slider colorSlider;
    private TextField colorDecimal, colorHex;

    public ColorLane(IntegerProperty color, String colorName) {
        this.color = color;
        this.colorName = colorName;
        initializeControls();
        layoutControls();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeControls() {
        this.colorLabel = new Label(colorName);
        this.colorSlider = new Slider();
        colorSlider.setMin(0);
        colorSlider.setMax(255);
        this.colorDecimal = new TextField();
        this.colorHex = new TextField();
    }

    private void layoutControls() {
        this.getChildren().addAll(colorLabel, colorSlider, colorDecimal, colorHex);
        for(Node control : this.getChildren()) {
            VBox.setMargin(control, new Insets(0, 0, 10, 0));
            VBox.setVgrow(control, Priority.ALWAYS);
        }
        this.setPadding(new Insets(10));
    }

    private void setupValueChangedListeners() {
        colorDecimal.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                colorDecimal.setText(String.valueOf(checkStringForValidValue(newValue)));
            } catch (RGBFormatException e) {
                colorHex.setText(oldValue);
            }
        });
        colorHex.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                String newValueAsDecimal = String.valueOf(Integer.parseInt(newValue, 16));
                colorHex.setText(Integer.toHexString(checkStringForValidValue(newValueAsDecimal)));
            } catch (RGBFormatException e) {
                colorHex.setText(oldValue);
            }
        });
    }

    private int checkStringForValidValue(String input) throws RGBFormatException {
        try {
            int newValueInt = Integer.parseInt(input);
            if(newValueInt >= 0 && newValueInt <= 255) {
                return newValueInt;
            }
        } catch (Exception e) {
            throw new RGBFormatException("Value not between 0 and 255", e);
        }
        return 0;
    }

    private void setupBindings() {
        colorSlider.valueProperty().bindBidirectional(color);

        colorDecimal.textProperty().bindBidirectional(color, new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                try {
                    return checkStringForValidValue(string);
                } catch (RGBFormatException e) {
                    return 0;
                }
            }
        });

        colorHex.textProperty().bindBidirectional(color, new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return Integer.toString((Integer) object, 16);
            }

            @Override
            public Number fromString(String string) {
                try {
                    String newValueAsDecimal = String.valueOf(Integer.parseInt(string, 16));
                    return checkStringForValidValue(newValueAsDecimal);
                } catch (RGBFormatException e) {
                    return 0;
                }
            }
        });
    }
}
