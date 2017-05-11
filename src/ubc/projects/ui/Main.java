package ubc.projects.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Constructs the GUI
 */
public class Main  extends Application{
    Label title;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the JavaFX Application.
     * @param primaryStage     The stage for the Game
     * @throws Exception       Thrown when an exception occurs.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Diplomacy");
        title = new Label("Diplomacy Title Screen");
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 250);
        layout.getChildren().add(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
