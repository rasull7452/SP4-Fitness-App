import java.sql.Connection;
import util.MySQLConnection;
import util.TextUI;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    String userId;
    String name;
    String gender;
    double weight;
    double height;
    int age;
    String activityLevel;
    double goal;
    String currentPlan;

    TextUI ui = new TextUI();

    public User(){
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.activityLevel = activityLevel;
        this.goal = goal;
        this.currentPlan = currentPlan;
    }

    public void createUser(){

        String chosenUsername = ui.promptText("Username: ");
        String chosenPassword = ui.promptText("Password: ");


        try {

            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

            Connection con = MySQLConnection.getConnection();

            PreparedStatement prst = con.prepareStatement(sql);

            prst.setString(1, chosenUsername);
            prst.setString(2, chosenPassword);

            prst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(){

    }
}
