package ch.schmucki.gui;

import ch.schmucki.presentationmodel.ColorPickerPM;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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

        // Add menu
        menuGroup = new ToggleGroupColor(colorPM);
        menu = new ColorPickerMenu(menuGroup);
        getChildren().add(menu);

        // Add 3 lanes for r, g, b
        redLane = new ColorLane(colorPM.redProperty(), "Red");
        greenLane = new ColorLane(colorPM.greenProperty(), "Green");
        blueLane = new ColorLane(colorPM.blueProperty(), "Blue");
        getChildren().addAll(redLane, greenLane, blueLane);

        // Grid
        GridPane grid = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(25);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);
        grid.getColumnConstraints().addAll(col1,col2,col3);

        // Setup preview pane and all the RadioButtons
        group = new ToggleGroupColor(colorPM);
        colorPane = new ColorPreviewPane(colorPM);
        grid.add(colorPane, 0,0, 1, group.getGroupMembers().size());

        for(int i = 0; i < group.getGroupMembers().size(); i++) {
            grid.add(group.getGroupMembers().get(i), 1, i);
        }

        // Add Brighter / Darker button
        lighten = new BrightnessChangeButton("Lighter", colorPM, true, 10);
        darken = new BrightnessChangeButton("Darker", colorPM, false, 10);
        grid.add(lighten, 2, 0);
        grid.add(darken, 2, 1);

        this.getChildren().add(grid);
    }
}
