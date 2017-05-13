package ubc.projects.ui;

import com.sun.javaws.exceptions.BadFieldException;
import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ubc.projects.model.Game;

import java.util.IllegalFormatException;


/**
 * Created by greggzik on 2017-05-12.
 */
public class Game_UI extends Scene {
    Game game;
    ImageView viewer;
    Image map;
    BorderPane mainLayout;
    VBox countries;
    VBox orders;

    /**
     * Creates a Scene for a specific root Node with a specific size.
     * @param root   The root node of the scene graph.
     * @param width  The width of the scene.
     * @param height The height of the scene.
     * @throws NullPointerException   if root is null.
     * @throws IllegalStateException  if root is not a BorderPane.
     */
    public Game_UI(@NamedArg("root") Parent root, @NamedArg("width") double width, @NamedArg("height") double height,
                   Game game) {
        super(root, width, height);
        if (!(root instanceof BorderPane)) throw new IllegalStateException("Root needs to be BorderPane");
        mainLayout = (BorderPane) root;
        this.game = game;
        viewer = new ImageView();
        map = new Image("file:Map_with_Abbreviations.png");
        viewer.setImage(map);
        mainLayout.setCenter(viewer);
        countries = new VBox(20);
        setUpCountries();
        orders = new VBox();
        setUpOrders();
        mainLayout.setLeft(countries);
        mainLayout.setRight(orders);
        HBox top = new HBox();
        HBox bottom = new HBox();
        Label title = new Label("Diplomacy");
        top.getChildren().add(title);
        title.setAlignment(Pos.CENTER);
        Button execute = new Button("End Turn");
        bottom.getChildren().add(execute);
        execute.setAlignment(Pos.CENTER);
        mainLayout.setTop(title);
        mainLayout.setBottom(execute);

    }

    private void setUpCountries() {
        Button england = new Button("England");
        Button france = new Button("France");
        Button austria = new Button("Austria-Hungary");
        Button germany = new Button("Germany");
        Button italy = new Button("Italy");
        Button turkey = new Button("Ottoman-Turkey");
        Button russia = new Button("Russia");
        countries.getChildren().addAll(england, france, austria, germany, italy, turkey, russia);
        countries.setAlignment(Pos.CENTER);
    }

    private void setUpOrders() {
        Label temp = new Label("This is temporary");
        orders.getChildren().add(temp);
        orders.setAlignment(Pos.CENTER);
    }
}
