package ubc.projects.ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ubc.projects.model.Game;


//TODO: Continue Implementation.
/**
 * Constructs the GUI
 */
public class Main  extends Application {
    Stage window;
    Scene startup, map;


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
        window = primaryStage;
        window.setTitle("Diplomacy");

        VBox layout = new VBox(20);

        startup = new Scene(layout, 500, 500);
        setStartScreen(layout);

        window.setScene(startup);
        window.show();
    }

    /**
     * Creates the scene for the startup.
     * @param layout
     */
    private void setStartScreen(VBox layout) {
        layout.setAlignment(Pos.CENTER);
        Label title = new Label("Diplomacy - Coded by Gregory Gzik");
        Button newgame = new Button("Start a new game");
        Button loadgame = new Button("Load from a previous save");

        newgame.setOnAction(e -> {
            map = new Game_UI(new BorderPane(), 1000, 800, new Game());
            window.setScene(map);
            window.centerOnScreen();
        });
        loadgame.setOnAction(e -> {});
        layout.getChildren().addAll(title, newgame, loadgame);
    }
}
