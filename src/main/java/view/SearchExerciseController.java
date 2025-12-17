// Lavet af Rasull
package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import util.Database;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import code.Exercise;

public class SearchExerciseController implements Initializable{

    @FXML
    private ListView<String> exerciseList;

    @FXML
    private Label searchedExercise;

    private Stage stage;
    private Scene scene;

    String currentExercise;
    List<Exercise> allExercises;

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
                //exercisesNames.add(rs.getString("name"));
                exercises.add(exercise);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercises;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        allExercises = getAllExercises();

        for (Exercise exercise : allExercises) {
            exerciseList.getItems().add(exercise.getName());
        }
    }


//    public void searchExercise(String searched){
//        searched = searchedExercise.getText();
//
//        for(String exercise : exerciseList){
//
//        }
//
//    }
}
