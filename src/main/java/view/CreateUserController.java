// Rasull

package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import util.MySQLConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUserController {
    @FXML
    TextField username;

    @FXML
    PasswordField password;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void createUser(ActionEvent event) throws IOException {

        String chosenUsername = username.getText();
        String chosenPassword = password.getText();

        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        String hashedPassword = BCrypt.hashpw(chosenPassword, BCrypt.gensalt());

        try {

            Connection con = MySQLConnection.getConnection();

            PreparedStatement prst = con.prepareStatement(sql);

            prst.setString(1, chosenUsername);
            prst.setString(2, hashedPassword);

            prst.executeUpdate();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            root = loader.load();

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
