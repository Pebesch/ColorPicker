package ch.schmucki.gui;

import ch.schmucki.presentationmodel.ColorPickerPM;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BrightnessChangeButton extends Button {
    private ColorPickerPM pm;
    private boolean brighten;
    private int changeInBrightness;

    public BrightnessChangeButton(String displayText, ColorPickerPM pm, boolean brighten, int changeInBrightness) {
        super(displayText);
        this.pm = pm;
        this.brighten = brighten;
        this.changeInBrightness = changeInBrightness;
        setupControl();
        setupChangeListener();
        setupBindings();
    }

    private void setupControl() {
        if(brighten) {
            setDisable(areMaxValuesReached());
        } else {
            setDisable(areMinValuesReached());
        }
    }

    private void setupChangeListener() {
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                adjustBrightness();
            }
        });
    }

    private void setupBindings() {
        pm.redProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(brighten) {
                    setDisable(areMaxValuesReached());
                } else {
                    setDisable(areMinValuesReached());
                }
            }
        });
        pm.greenProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(brighten) {
                    setDisable(areMaxValuesReached());
                } else {
                    setDisable(areMinValuesReached());
                }
            }
        });
        pm.blueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(brighten) {
                    setDisable(areMaxValuesReached());
                } else {
                    setDisable(areMinValuesReached());
                }
            }
        });
    }


    private void adjustBrightness() {
        if(brighten) {
            pm.brightenRed(changeInBrightness);
            pm.brightenGreen(changeInBrightness);
            pm.brightenBlue(changeInBrightness);
        } else {
            pm.darkenRed(changeInBrightness);
            pm.darkenGreen(changeInBrightness);
            pm.darkenBlue(changeInBrightness);
        }
    }

    private boolean areMaxValuesReached() {
        return pm.redProperty().getValue() == 255 &&
                pm.greenProperty().getValue() == 255 &&
                pm.blueProperty().getValue() == 255;
    }

    private boolean areMinValuesReached() {
        return pm.redProperty().getValue() == 0 &&
                pm.greenProperty().getValue() == 0 &&
                pm.blueProperty().getValue() == 0;
    }
}
