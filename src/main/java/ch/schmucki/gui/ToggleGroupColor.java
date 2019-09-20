package ch.schmucki.gui;

import ch.schmucki.presentationmodel.ColorPickerPM;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class ToggleGroupColor extends ToggleGroup {
    private ColorPickerPM pm;
    private ColoredRadioButton red, green, blue, yellow, cyan, magenta, white, black;
    private List<ColoredRadioButton> groupMembers;

    public ToggleGroupColor(ColorPickerPM pm) {
        this.pm = pm;
        this.groupMembers = new ArrayList<>();
        initializeControls();
    }

    private void initializeControls() {
        this.red = new ColoredRadioButton("Red", pm, 255, 0, 0);
        this.green = new ColoredRadioButton("Green", pm, 0, 255, 0);
        this.blue = new ColoredRadioButton("Blue", pm, 0, 0, 255);
        this.yellow = new ColoredRadioButton("Yellow", pm, 255, 255, 0);
        this.cyan = new ColoredRadioButton("Cyan", pm, 0, 255, 255);
        this.magenta = new ColoredRadioButton("Magenta", pm, 255, 0, 255);
        this.white = new ColoredRadioButton("White", pm, 255, 255, 255);
        this.black = new ColoredRadioButton("Black", pm, 0, 0, 0);
        groupMembers.add(red);
        groupMembers.add(green);
        groupMembers.add(blue);
        groupMembers.add(yellow);
        groupMembers.add(cyan);
        groupMembers.add(magenta);
        groupMembers.add(white);
        groupMembers.add(black);
        for (ColoredRadioButton member : groupMembers) {
            member.setToggleGroup(this);
        }
    }

    public List<ColoredRadioButton> getGroupMembers() {
        return groupMembers;
    }
}
