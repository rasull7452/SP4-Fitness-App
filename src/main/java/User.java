import java.sql.Connection;

import org.mindrot.jbcrypt.BCrypt;
import util.MySQLConnection;
import util.TextUI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        String hashedPassword = BCrypt.hashpw(chosenPassword, BCrypt.gensalt());


        try {

            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

            Connection con = MySQLConnection.getConnection();

            PreparedStatement prst = con.prepareStatement(sql);

            prst.setString(1, chosenUsername);
            prst.setString(2, hashedPassword);

            prst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void login(){
        String submittedUsername = ui.promptText("Username: ");
        String submittedPassword = ui.promptText("Password: ");

        try {

            String sql1 = "SELECT username, password FROM users WHERE username = ?";

            Connection con = MySQLConnection.getConnection();

            PreparedStatement prst = con.prepareStatement(sql1);
            prst.setString(1, submittedUsername);

            ResultSet rs = prst.executeQuery();
            rs.next();
            String hashPassword = rs.getString("password");
            System.out.println(BCrypt.checkpw(submittedPassword, hashPassword));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
