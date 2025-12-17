// Lavet af Rasull

package code;

public class Exercise {
    private int id;
    private String name;
    private int sets;
    private int reps;
    private int restTimeSeconds;
    private String exerciseDescription;
    private String videoUrl;
    private String primaryMuscles;
    private String secondaryMuscles;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public int getRestTimeSeconds() {
        return restTimeSeconds;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getPrimaryMuscles() {
        return primaryMuscles;
    }

    public String getSecondaryMuscles() {
        return secondaryMuscles;
    }
}
