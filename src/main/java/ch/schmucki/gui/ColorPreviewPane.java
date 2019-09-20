package ch.schmucki.gui;

import javafx.beans.property.IntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorPreviewPane extends Rectangle {
    private IntegerProperty red, green, blue;

    public ColorPreviewPane (IntegerProperty red, IntegerProperty green, IntegerProperty blue) {
        this.setWidth(300);
        this.setHeight(150);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.setFill(Color.rgb(red.getValue(), green.getValue(), blue.getValue()));
        setupChangeListener();
    }

    private void setupChangeListener() {
        red.addListener((observable, oldValue, newValue) -> setFill(Color.rgb(red.getValue(), green.getValue(), blue.getValue())));
        green.addListener((observable, oldValue, newValue) -> setFill(Color.rgb(red.getValue(), green.getValue(), blue.getValue())));
        blue.addListener((observable, oldValue, newValue) -> setFill(Color.rgb(red.getValue(), green.getValue(), blue.getValue())));
    }

}
