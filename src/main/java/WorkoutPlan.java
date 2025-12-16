// Rasull

import java.util.ArrayList;
import java.util.List;

public class WorkoutPlan {
    String planId;
    List<Exercise> exercises = new ArrayList<>();
    double progress;

    public WorkoutPlan(String planId, List<Exercise> exercises, double progress){

        this.planId = planId;
        this.exercises = exercises;
        this.progress = progress;

    }
}
