package ch.schmucki.gui;

import javafx.beans.property.IntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorPreviewPane extends Rectangle {
    private IntegerProperty red, green, blue;

    public ColorPreviewPane (IntegerProperty red, IntegerProperty blue, IntegerProperty green) {
        this.setWidth(300);
        this.setHeight(150);
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.setFill(Color.rgb(red.getValue(), blue.getValue(), green.getValue()));
        setupChangeListener();
    }

    private void setupChangeListener() {
        red.addListener((observable, oldValue, newValue) -> setFill(Color.rgb(red.getValue(), blue.getValue(), green.getValue())));
        blue.addListener((observable, oldValue, newValue) -> setFill(Color.rgb(red.getValue(), blue.getValue(), green.getValue())));
        green.addListener((observable, oldValue, newValue) -> setFill(Color.rgb(red.getValue(), blue.getValue(), green.getValue())));
    }

}
