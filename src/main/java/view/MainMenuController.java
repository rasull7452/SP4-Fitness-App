// Rasull
package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController {
    @FXML
    Label usernameLabel;

    public void displayName(String username){
        usernameLabel.setText(username);
    }
}
