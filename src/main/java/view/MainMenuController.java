// Lavet af Rasull
package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;



public class MainMenuController {
    private Scene scene;
    private Parent root;
    private Stage stage;

    @FXML
    private Label usernameLabel;

    public void initialize(){
        usernameLabel.setText("User: " + LoginController.getLoggedInUser());
    }

    public void switchToSearchExercise(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchExercise.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
