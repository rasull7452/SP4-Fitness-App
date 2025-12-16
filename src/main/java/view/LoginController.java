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
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    TextField username;

    @FXML
    PasswordField password;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static String loggedInUser;

//    public void login(ActionEvent event) throws IOException {
//
//        String submittedUsername = username.getText();
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
//        root = loader.load();
//
//        MainMenuController mainMenuController = loader.getController();
//        mainMenuController.displayName(submittedUsername);
//
//        // root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    public boolean isLoginSuccessful(String submittedUsername, String submittedPassword) {

        String sql = "SELECT password FROM users WHERE username = ?";

        try {
            Connection con = MySQLConnection.getConnection();

            PreparedStatement prst = con.prepareStatement(sql);
            prst.setString(1, submittedUsername);

            ResultSet rs = prst.executeQuery();

            if(rs.next()){
                String hashPassword = rs.getString("password");
                return BCrypt.checkpw(submittedPassword, hashPassword);
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToStartMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        root = loader.load();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void login(ActionEvent event) throws IOException {
        String submittedUsername = username.getText();
        String submittedPassword = password.getText();

        if(isLoginSuccessful(submittedUsername, submittedPassword)){
            loggedInUser = submittedUsername;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            root = loader.load();

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

            MainMenuController mainMenuController = loader.getController();
            mainMenuController.displayName(submittedUsername);
        } else {
            switchToStartMenu(event);
        }
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }
}
