package ch.schmucki.gui;

import ch.schmucki.presentationmodel.ColorPickerPM;
import javafx.beans.property.IntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorPreviewPane extends Rectangle {
    private ColorPickerPM pm;

    public ColorPreviewPane (ColorPickerPM pm) {
        this.setWidth(300);
        this.setHeight(150);
        this.pm = pm;
        this.setFill(Color.rgb(pm.getRed(), pm.getGreen(), pm.getBlue()));
        setupChangeListener();
    }

    public ColorPreviewPane (ColorPickerPM pm, int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
        this.pm = pm;
        this.setFill(Color.rgb(pm.getRed(), pm.getGreen(), pm.getBlue()));
        setupChangeListener();
    }

    private void setupChangeListener() {
        pm.redProperty().addListener((observable, oldValue, newValue) -> setFill(Color.rgb(pm.getRed(), pm.getGreen(), pm.getBlue())));
        pm.greenProperty().addListener((observable, oldValue, newValue) -> setFill(Color.rgb(pm.getRed(), pm.getGreen(), pm.getBlue())));
        pm.blueProperty().addListener((observable, oldValue, newValue) -> setFill(Color.rgb(pm.getRed(), pm.getGreen(), pm.getBlue())));
    }

}
