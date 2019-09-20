package ch.schmucki.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class ColoredMenuItem extends MenuItem {
    public ColoredMenuItem(ColoredRadioButton button) {
        super("", button);

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button.setSelected(true);
            }
        });
    }
}
