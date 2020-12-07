package my.itis.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML
    private Button helloButton;

    @FXML
    private Label helloLabel;

    @FXML
    private Circle player;

    @FXML
    private AnchorPane paned;

    public EventHandler<KeyEvent> keyEventEventHandler = event -> {
        if (event.getCode() == KeyCode.LEFT) {
            player.setLayoutX(player.getLayoutX() - 5);
        } else if (event.getCode() == KeyCode.RIGHT) {
            player.setLayoutX(player.getLayoutX() + 5);
        } else if (event.getCode() == KeyCode.UP) {
            player.setLayoutY(player.getLayoutY() - 5);
        } else if (event.getCode() == KeyCode.DOWN) {
            player.setLayoutY(player.getLayoutY() + 5);
        } else if (event.getCode() == KeyCode.CONTROL) {
            Circle enemy = new Circle(player.getLayoutX(), player.getLayoutY(), 10, Color.RED);
            paned.getChildren().add(enemy);

            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.005), animation -> {
                enemy.setLayoutX(enemy.getLayoutX() + 5);
            }));
            timeline.setCycleCount(100);
            timeline.play();
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        helloButton.setOnAction(event -> {
            helloLabel.setText("Пока");
        });
    }
}
