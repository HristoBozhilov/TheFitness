import java.util.ArrayList;
import java.util.List;

public class Instructor implements Observable{
    private List<Observer> trainees;

    public Instructor() {
        trainees = new ArrayList<>();
    }

    public void addTrainee(Observer trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Observer trainee) {
        trainees.remove(trainee);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer trainee : trainees) {
            trainee.update(message);
        }
    }

    public void setTrainingMode(Trainee trainee, TrainingProgram program) {
        String trainingMode = program.getDescription();
        trainee.update(trainingMode);
        String message = "Setting training mode for " + trainee.getName() + " to: " + trainingMode;
        notifyObservers(message);
    }
}
