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
public class Main  extends Application implements EventHandler<ActionEvent>{
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
        // TODO: Change Placement of Buttons on screen.
        title = new Label("Choose your country:");
        ObservableList<Node> children = layout.getChildren();

        england = new Button("United Kingdom");
        england.setOnAction(this);
        children.add(england);

        france = new Button("France");
        france.setOnAction(this);
        children.add(france);

        germany = new Button("Germany");
        germany.setOnAction(this);
        children.add(germany);

        russia = new Button("Russia");
        russia.setOnAction(this);
        children.add(russia);

        turkey = new Button("Ottoman Turkey");
        turkey.setOnAction(this);
        children.add(turkey);

        italy = new Button("Italy");
        italy.setOnAction(this);
        children.add(italy);

        austria = new Button("Austria-Hungary");
        austria.setOnAction(this);
        children.add(austria);
    }

    /**
     * Handles when the buttons are pressed during the start up screen.
     * @param event     The event of the pressed button.
     */
    @Override
    public void handle(ActionEvent event) {
        System.out.println("The user pressed a button"); //TODO: Implement Desired Functinality
    }
}
