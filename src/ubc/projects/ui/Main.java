package ubc.projects.ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


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

        VBox layout1 = new VBox(20);
        StackPane layout2 = new StackPane();
        startup = new Scene(layout1, 800, 800);
        map = new Scene(layout2, 800, 800);
        setStartScreen(layout1);
        setMapScene(layout2);

        window.setScene(startup);
        window.show();
    }

    /**
     * Constructs the initial starting screen.
     * @param layout  The layout for the scene.
     */
    private void setStartScreen(VBox layout) {
        Label text = new Label("Choose your country:");
        ObservableList<Node> children = layout.getChildren();
        children.add(text);

        Button england = new Button("United Kingdom");
        england.setOnAction(e -> window.setScene(map));
        children.add(england);

        Button france = new Button("France");
        france.setOnAction(e -> window.setScene(map));
        children.add(france);

        Button germany = new Button("Germany");
        germany.setOnAction(e -> window.setScene(map));
        children.add(germany);

        Button russia = new Button("Russia");
        russia.setOnAction(e -> window.setScene(map));
        children.add(russia);

        Button turkey = new Button("Ottoman Turkey");
        turkey.setOnAction(e -> window.setScene(map));
        children.add(turkey);

        Button italy = new Button("Italy");
        italy.setOnAction(e -> window.setScene(map));
        children.add(italy);

        Button austria = new Button("Austria-Hungary");
        austria.setOnAction(e -> window.setScene(map));
        children.add(austria);
    }

    private void setMapScene(StackPane layout) {
        Label label = new Label("This is another scene");
        layout.getChildren().add(label);
    }

}
