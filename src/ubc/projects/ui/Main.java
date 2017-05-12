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


//TODO: Continue Implementation.
/**
 * Constructs the GUI
 */
public class Main  extends Application {
    Stage window;
    Scene startup, newGame, map;


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

        VBox layout1 = new VBox(20);
        VBox layout2 = new VBox(20);
        BorderPane layout3 = new BorderPane();

        startup = new Scene(layout1, 800, 800);
        newGame = new Scene(layout2, 800, 800);
        map = new Scene(layout3, 800, 800);
        setStartScreen(layout1);
        setNewGameScreen(layout2);
        setMapScene(layout3);

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
        newgame.setOnAction(e -> window.setScene(newGame));
        layout.getChildren().addAll(title, newgame, loadgame);
    }

    /**
     * Constructs the initial new game screen.
     * @param layout  The layout for the scene.
     */
    private void setNewGameScreen(VBox layout) {
        Label text = new Label("First Player - Choose your Country.");
        layout.setAlignment(Pos.CENTER);
        ObservableList<Node> children = layout.getChildren();
        children.add(text);

        Button england = new Button("United Kingdom");
        england.setOnAction(e -> {
            text.setText("Next Player - Choose your Country. \n Start game when all players have countries.");
            england.setDisable(true);
        });
        children.add(england);

        Button france = new Button("France");
        france.setOnAction(e -> {
            text.setText("Next Player - Choose your Country. \n Start game when all players have countries.");
            france.setDisable(true);
        });
        children.add(france);

        Button germany = new Button("Germany");
        germany.setOnAction(e -> {
            text.setText("Next Player - Choose your Country. \n Start game when all players have countries.");
            germany.setDisable(true);
        });
        children.add(germany);

        Button russia = new Button("Russia");
        russia.setOnAction(e -> {
            text.setText("Next Player - Choose your Country. \n Start game when all players have countries.");
            russia.setDisable(true);
        });
        children.add(russia);

        Button turkey = new Button("Ottoman Turkey");
        turkey.setOnAction(e -> {
            text.setText("Next Player - Choose your Country. \n Start game when all players have countries.");
            turkey.setDisable(true);
        });
        children.add(turkey);

        Button italy = new Button("Italy");
        italy.setOnAction(e -> {
            text.setText("Next Player - Choose your Country. \n Start game when all players have countries.");
            italy.setDisable(true);
        });
        children.add(italy);

        Button austria = new Button("Austria-Hungary");
        austria.setOnAction(e -> {
            text.setText("Next Player - Choose your Country. \n Start game when all players have countries.");
            austria.setDisable(true);
        });
        children.add(austria);

        Button start = new Button("Start your Game");
        start.setOnAction(e -> {
           if (england.isDisable() && france.isDisable() && germany.isDisable() && russia.isDisable() &&
                   turkey.isDisable() && italy.isDisable() && austria.isDisable())
               window.setScene(map);
        });
        children.add(start);
    }

    private void setMapScene(BorderPane layout) {
        ImageView viewer = new ImageView();
        Image image = new Image("file:Map_with_Abbreviations.png");
        viewer.setImage(image);
        layout.setCenter(viewer);
    }

}
