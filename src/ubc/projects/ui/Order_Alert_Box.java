package ubc.projects.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ubc.projects.model.game.Player;
import ubc.projects.model.game.Unit;

/**
 * Created by greggzik on 2017-05-29.
 */
public class Order_Alert_Box {

    /**
     * Displays an Alert Box indicating the players intended unit orders.
     * @param player    The player to interact with the AlertBox.
     */
    public static void display(Player player) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Orders for " + player.getCountry());
        window.setMinWidth(250);

        Label label = new Label("The units of " + player.getCountry() + " have the following orders: ");

        VBox layout = new VBox(10);
        layout.getChildren().add(label);

        for (Unit unit : player.getUnits()) {
            Label unitText = new Label(unit.toString() + " " + unit.getOrder().toString());
            layout.getChildren().add(unitText);
        }

        HBox buttonLayout = new HBox(10);

        Button confirm = new Button("Confirm");
        Button deny    = new Button("Change Orders");

        confirm.setOnAction(e -> {
            player.confirmOrders();
            window.close();
        });
        deny.setOnAction(e -> window.close());

        buttonLayout.getChildren().addAll(confirm, deny);

        layout.getChildren().add(buttonLayout);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
