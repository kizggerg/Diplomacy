package ubc.projects.ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Observable;

/**
 * Constructs the GUI
 */
public class Main  extends Application {
    Label title;
    Button england, france, germany, russia, turkey, italy, austria;

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
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 250);
        setStartScreen(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Constructs the initial starting screen.
     * @param layout  The layout for the scene.
     */
    private void setStartScreen(StackPane layout) {
        // TODO: Change Placement of Buttons on screen, Implment handle functionality.
        title = new Label("Choose your country:");
        ObservableList<Node> children = layout.getChildren();

        england = new Button("United Kingdom");
        england.setOnAction(e -> System.out.println("England Pressed"));
        children.add(england);

        france = new Button("France");
        france.setOnAction(e -> System.out.println("France Pressed"));
        children.add(france);

        germany = new Button("Germany");
        germany.setOnAction(e -> System.out.println("Germany Pressed"));
        children.add(germany);

        russia = new Button("Russia");
        russia.setOnAction(e -> System.out.println("Russia Pressed"));
        children.add(russia);

        turkey = new Button("Ottoman Turkey");
        turkey.setOnAction(e -> System.out.println("Turkey Pressed"));
        children.add(turkey);

        italy = new Button("Italy");
        italy.setOnAction(e -> System.out.println("Italy Pressed"));
        children.add(italy);

        austria = new Button("Austria-Hungary");
        austria.setOnAction(e -> System.out.println("Austria Pressed"));
        children.add(austria);
    }

}
