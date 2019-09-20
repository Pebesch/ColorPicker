package ch.schmucki.presentationmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ColorPickerPM {
    private IntegerProperty red = new SimpleIntegerProperty();
    private IntegerProperty green = new SimpleIntegerProperty();
    private IntegerProperty blue = new SimpleIntegerProperty();

    public int getRed() {
        return red.get();
    }

    public IntegerProperty redProperty() {
        return red;
    }

    public void setRed(int red) {
        if(red >= 0 && red <= 255)
            this.red.set(red);
    }

    public void brightenRed(int brightenBy) {
        if (getRed() + brightenBy <= 255) {
            setRed(getRed() + brightenBy);
        } else {
            setRed(255);
        }
    }

    public void darkenRed(int darkenBy) {
        if (getRed() - darkenBy >= 0) {
            setRed(getRed() - darkenBy);
        } else {
            setRed(0);
        }
    }

    public int getGreen() {
        return green.get();
    }

    public IntegerProperty greenProperty() {
        return green;
    }

    public void setGreen(int green) {
        if(green >= 0 && green <= 255)
            this.green.set(green);
    }

    public void brightenGreen(int brightenBy) {
        if (getGreen() + brightenBy <= 255) {
            setGreen(getGreen() + brightenBy);
        } else {
            setGreen(255);
        }
    }

    public void darkenGreen(int darkenBy) {
        if (getGreen() - darkenBy >= 0) {
            setGreen(getGreen() - darkenBy);
        } else {
            setGreen(0);
        }
    }

    public int getBlue() {
        return blue.get();
    }

    public IntegerProperty blueProperty() {
        return blue;
    }

    public void setBlue(int blue) {
        if(blue >= 0 && blue <= 255)
            this.blue.set(blue);
    }

    public void brightenBlue(int brightenBy) {
        if (getBlue() + brightenBy <= 255) {
            setBlue(getBlue() + brightenBy);
        } else {
            setBlue(255);
        }
    }

    public void darkenBlue(int darkenBy) {
        if (getBlue() - darkenBy >= 0) {
            setBlue(getBlue() - darkenBy);
        } else {
            setBlue(0);
        }
    }
}
