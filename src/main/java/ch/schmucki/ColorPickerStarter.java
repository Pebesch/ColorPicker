package ch.schmucki;

import ch.schmucki.gui.ColorPickerUI;
import ch.schmucki.presentationmodel.ColorPickerPM;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorPickerStarter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ColorPickerPM rootPM = new ColorPickerPM();
        Parent rootPanel = new ColorPickerUI(rootPM);
        Scene scene = new Scene(rootPanel);

        primaryStage.setTitle("Color Picker");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
