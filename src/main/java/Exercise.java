// Rasull
public class Exercise {
    int id;
    String name;
    int sets;
    int reps;
    int restTimeSeconds;
    String exerciseDescription;
    String videoUrl;
    String primaryMuscles;
    String secondaryMuscles;

    public Exercise(int id, String name, int sets, int reps, int restTimeSeconds, String exerciseDescription, String videoUrl, String primaryMuscles, String secondaryMuscles){
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.restTimeSeconds = restTimeSeconds;
        this.exerciseDescription = exerciseDescription;
        this.videoUrl = videoUrl;
        this.primaryMuscles = primaryMuscles;
        this.secondaryMuscles = secondaryMuscles;

    }

}
