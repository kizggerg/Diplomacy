package ubc.projects.ui;

import javafx.beans.NamedArg;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ubc.projects.exceptions.IllegalOrderException;
import ubc.projects.model.map.Country;
import ubc.projects.model.game.Army;
import ubc.projects.model.game.Game;
import ubc.projects.model.game.Player;
import ubc.projects.model.game.Unit;
import ubc.projects.model.map.Land;
import ubc.projects.model.map.Place;


/**
 * Created by greggzik on 2017-05-12.
 * The main game scene.
 */
public class Game_UI extends Scene {
    private Game game;
    private ImageView viewer;
    private Image map;
    private BorderPane mainLayout;
    private VBox countries;
    private VBox orders;
    private String phase;


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
        orders = new VBox(20);
        phase = this.game.getPhase();
        setUpGeneralFrame();
        setUpCountries();
        updateOrdersPane(null);
    }

    /**
     * Sets up the graphics of the scene
     */
    private void setUpGeneralFrame() {
        mainLayout.setLeft(countries);
        mainLayout.setRight(orders);
        HBox top = new HBox();
        HBox bottom = new HBox();
        Label title = new Label(phase);
        top.getChildren().add(title);
        Button execute = new Button("End Turn");
        bottom.getChildren().add(execute);
        mainLayout.setTop(title);
        mainLayout.setBottom(execute);
        mainLayout.setAlignment(title, Pos.CENTER);
        mainLayout.setAlignment(countries, Pos.CENTER);
        mainLayout.setAlignment(orders, Pos.CENTER);
    }

    /**
     * Sets up the country pane.
     */
    private void setUpCountries() {
        Button england = new Button("England"); england.setOnAction(e -> updateOrdersPane(Country.ENGLAND));
        Button france = new Button("France"); france.setOnAction(e -> updateOrdersPane(Country.FRANCE));
        Button austria = new Button("Austria-Hungary"); austria.setOnAction(e -> updateOrdersPane(Country.AUSTRA_HUNGARY));
        Button germany = new Button("Germany"); germany.setOnAction(e -> updateOrdersPane(Country.GERMANY));
        Button italy = new Button("Italy"); italy.setOnAction(e -> updateOrdersPane(Country.ITALY));
        Button turkey = new Button("Ottoman-Turkey"); turkey.setOnAction(e -> updateOrdersPane(Country.TURKEY));
        Button russia = new Button("Russia"); russia.setOnAction(e -> updateOrdersPane(Country.RUSSIA));
        countries.getChildren().addAll(england, france, austria, germany, italy, turkey, russia);
        countries.setAlignment(Pos.CENTER);
    }

    /**
     * Updates the orders pane when a country is selected.
     */
    private void updateOrdersPane(Country country) {
        orders.getChildren().clear();

        if (country == null) {
            Label initialOrderLabel = new Label("Select a Country to give orders.");
            orders.getChildren().add(initialOrderLabel);
            orders.setAlignment(Pos.CENTER);
        }

        else {
            Player selected = game.getPlayer(country);

            for (Unit unit : selected.getUnits()) {
                HBox unitBox = new HBox(10);
                Label unitName = new Label(unit.toString());

                ComboBox<String> theOrders = new ComboBox<>();
                theOrders.getItems().addAll("Hold", "Move", "Support", "Convoy");
                theOrders.setValue(unit.getOrder().getType());

                unitBox.getChildren().addAll(unitName, theOrders);
                theOrders.getSelectionModel().selectedItemProperty().addListener(
                        (a, old, orderSelected) -> handleOrdersUI(orderSelected, unit, unitBox));
                handleOrdersUI(theOrders.getValue(), unit, unitBox);
                orders.getChildren().add(unitBox);
            }

        }
    }

    /**
     * Adds the orders UI when a selection is chosen in the ComboBox.
     * @param order       The order chosen in the ComboBox.
     * @param unit        The unit in which the player wishes to order.
     * @param unitBox     The HBox containing the UI for the unit.
     */
    private void handleOrdersUI(String order, Unit unit, HBox unitBox) {
        if (order.equals("Hold")) return;

        boolean isArmy = (unit instanceof Army); // True for Army, False for Fleet
        ComboBox<Place> destination = new ComboBox<>();
        for (Place adjacent : unit.getLocation().getAdjacentPlaces()) {
            if (isArmy) {
                if (adjacent instanceof Land) destination.getItems().add(adjacent);
            }
            else {
                if (!(adjacent instanceof Land && ((Land) adjacent).isLandlocked())) destination.getItems().add(adjacent);
            }
        }

        switch (order) {
            case "Move"    : {
                destination.setPromptText("Destination");
                destination.getSelectionModel().selectedItemProperty().addListener( (v, a, option) -> addMoveOrder(unit, option));
                break;
            }
            case "Support" : break; //todo: Implement the rest
            case  "Convoy" : break;
            default        : break;
        }

        unitBox.getChildren().add(destination);
    }

    /**
     * Adds a move order to the given Unit.
     * @param unit          The unit to add the move order.
     * @param destination   The destination of the move order.
     */
    private void addMoveOrder(Unit unit, Place destination) {
        try {
            unit.setToMove(destination);
        }
        catch (IllegalOrderException e) {
            System.out.println(e.getMessage());
        }
    }
}
