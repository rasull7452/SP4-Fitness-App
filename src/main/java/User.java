// Rasull

import java.sql.Connection;

import org.mindrot.jbcrypt.BCrypt;
import util.MySQLConnection;
import util.TextUI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String userId;
    private String name;
    private String gender;
    private double weight;
    private double height;
    private int age;
    private String activityLevel;
    private double goal;
    private String currentPlan;

    private TextUI ui = new TextUI();

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

//    public boolean isLoginSuccessful(String submittedUsername, String submittedPassword) {
//
//        String sql = "SELECT password FROM users WHERE username = ?";
//
//        try {
//            Connection con = MySQLConnection.getConnection();
//
//            PreparedStatement prst = con.prepareStatement(sql);
//            prst.setString(1, submittedUsername);
//
//            ResultSet rs = prst.executeQuery();
//
//            if(rs.next()){
//                String hashPassword = rs.getString("password");
//                return BCrypt.checkpw(submittedPassword, hashPassword);
//            } else {
//                return false;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public void createUser(){
//
//        String chosenUsername = ui.promptText("Username: ");
//        String chosenPassword = ui.promptText("Password: ");
//
//        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
//
//        String hashedPassword = BCrypt.hashpw(chosenPassword, BCrypt.gensalt());
//
//        try {
//
//            Connection con = MySQLConnection.getConnection();
//
//            PreparedStatement prst = con.prepareStatement(sql);
//
//            prst.setString(1, chosenUsername);
//            prst.setString(2, hashedPassword);
//
//            prst.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public void login(){
//        String submittedUsername = ui.promptText("Username: ");
//        String submittedPassword = ui.promptText("Password: ");
//
//        if(isLoginSuccessful(submittedUsername, submittedPassword)){
//            ui.displayMsg("You have successfully logged in as " + submittedUsername);
//        } else {
//            ui.displayMsg("Invalid username or password, try again");
//            login();
//        }
//    }

//    public static String getLoggedInUser() {
//    }
}
