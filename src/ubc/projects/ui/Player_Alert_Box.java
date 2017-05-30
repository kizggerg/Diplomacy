package ubc.projects.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ubc.projects.model.game.Game;
import ubc.projects.model.game.Player;
import ubc.projects.model.game.Unit;


/**
 * Created by greggzik on 2017-05-29.
 */
public class Player_Alert_Box {

    /**
     * Displays an Alert Box indicating the players who have not confirmed their orders yet.
     * @param game    The current game.
     */
    public static void display(Game game) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Cannot End Turn");
        window.setMinWidth(250);

        Label label = new Label("The following players have not submitted their orders:");

        VBox layout = new VBox(10);
        layout.getChildren().add(label);

        for (Player player : game.getPlayersWithUnconfirmedOrders()) {
            Label playerText = new Label(player.getCountry().toString());
            layout.getChildren().add(playerText);
        }

        Button confirm = new Button("Okay");

        confirm.setOnAction(e -> window.close());

        layout.getChildren().add(confirm);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
