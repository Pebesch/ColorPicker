package ch.schmucki.gui;

import ch.schmucki.presentationmodel.ColorPickerPM;
import javafx.scene.layout.VBox;

public class ColorPickerUI extends VBox {
    private ColorPickerPM colorPM;
    private ColorLane redLane, greenLane, blueLane;
    private ColorPreviewPane colorPane;
    private ToggleGroupColor menuGroup, group;
    private ColorPickerMenu menu;
    private BrightnessChangeButton lighten, darken;

    public ColorPickerUI(ColorPickerPM rootPM) {
        this.colorPM = rootPM;
        menuGroup = new ToggleGroupColor(colorPM);
        menu = new ColorPickerMenu(menuGroup);
        getChildren().add(menu);
        redLane = new ColorLane(colorPM.redProperty(), "Red");
        greenLane = new ColorLane(colorPM.greenProperty(), "Green");
        blueLane = new ColorLane(colorPM.blueProperty(), "Blue");
        colorPane = new ColorPreviewPane(colorPM);
        getChildren().addAll(redLane, greenLane, blueLane, colorPane);
        group = new ToggleGroupColor(colorPM);
        getChildren().addAll(group.getGroupMembers());
        lighten = new BrightnessChangeButton("Lighter", colorPM, true, 10);
        darken = new BrightnessChangeButton("Darker", colorPM, false, 10);
        getChildren().addAll(lighten, darken);
    }
}
