package ch.schmucki.gui;

import ch.schmucki.presentationmodel.ColorPickerPM;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class ColorPickerUI extends VBox {
    private ColorPickerPM colorPM;
    private ColorLane redLane, greenLane, blueLane;
    private ColorPreviewPane colorPane;
    private ToggleGroupColor group;

    public ColorPickerUI(ColorPickerPM rootPM) {
        this.colorPM = rootPM;
        redLane = new ColorLane(colorPM.redProperty(), "Red");
        greenLane = new ColorLane(colorPM.greenProperty(), "Green");
        blueLane = new ColorLane(colorPM.blueProperty(), "Blue");
        colorPane = new ColorPreviewPane(colorPM.redProperty(), colorPM.greenProperty(), colorPM.blueProperty());
        getChildren().addAll(redLane, greenLane, blueLane, colorPane);
        group = new ToggleGroupColor(colorPM);
        getChildren().addAll(group.getGroupMembers());
    }
}
