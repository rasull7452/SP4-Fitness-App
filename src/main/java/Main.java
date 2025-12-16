import util.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        User u = new User();
        //u.createUser();
//        u.login();
//        System.out.println("Logged in as: " + User.getLoggedInUser());

    }

    public static List<Exercise> getAllExercises() {

        List<Exercise> exercises = new ArrayList<>();

        String sql = "SELECT * FROM exercises";

        try {

            Connection con = Database.getConnection();

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Exercise exercise = new Exercise(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("sets"),
                        rs.getInt("reps"),
                        rs.getInt("restTimeSeconds"),
                        rs.getString("exerciseDescription"),
                        rs.getString("videoUrl"),
                        rs.getString("primaryMuscles"),
                        rs.getString("secondaryMuscles")
                );
                exercises.add(exercise);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercises;
    }

}
