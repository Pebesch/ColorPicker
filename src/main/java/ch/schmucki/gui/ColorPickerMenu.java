package ch.schmucki.gui;

import ch.schmucki.presentationmodel.ColorPickerPM;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class ColorPickerMenu extends MenuBar {
    private ToggleGroupColor toggleGroup;
    private Menu file, color;

    public ColorPickerMenu(ToggleGroupColor toggleGroup) {
        this.toggleGroup = toggleGroup;
        initializeControls();
    }

    private void initializeControls() {
        file = new Menu("File");
        color = new Menu("Color");
        for (ColoredRadioButton button : toggleGroup.getGroupMembers()) {
            color.getItems().add(new ColoredMenuItem(button));
        }
        this.getMenus().addAll(file, color);
    }

}
