package my.itis.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import my.itis.controllers.MainController;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        String fxml = "/fxml/Main.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        stage.setTitle("first");
        stage.setScene(new Scene(root));
        stage.setResizable(false);

        Scene scene = stage.getScene();
        MainController controller = loader.getController();
        scene.setOnKeyPressed(controller.keyEventEventHandler);

        stage.show();
    }
}
