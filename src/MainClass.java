import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        // Get the single instance of the Gym (Singleton pattern)
        Gym gym = Gym.getInstance();

        // Create an Instructor
        Instructor instructor = new Instructor();

        gym.addInstructor(instructor);

        // Create Trainees
        List<Trainee> trainees = new ArrayList<>();
        trainees.add(new Trainee("Alice"));
        trainees.add(new Trainee("Bob"));

        // Register Trainees to the Instructor
        for (Trainee trainee : trainees) {
            instructor.addTrainee(trainee);
        }

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Set training mode for a trainee");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Select trainee:");
                    for (int i = 0; i < trainees.size(); i++) {
                        System.out.println((i + 1) + ". " + trainees.get(i).getName());
                    }
                    int traineeChoice = scanner.nextInt();
                    Trainee selectedTrainee;
                    if (traineeChoice >= 1 && traineeChoice <= trainees.size()) {
                        selectedTrainee = trainees.get(traineeChoice - 1);
                    } else {
                        System.out.println("Invalid trainee choice.");
                        continue;
                    }

                    System.out.println("Select training mode:");
                    System.out.println("1. Basic Training Program");
                    System.out.println("2. Basic + Cardio Training Program");
                    System.out.println("3. Basic + Strength Training Program");

                    int modeChoice = scanner.nextInt();
                    TrainingModeStrategy trainingModeStrategy;
                    TrainingProgram baseProgram = new BasicTrainingProgram();

                    switch (modeChoice) {
                        case 1:
                            trainingModeStrategy = program -> baseProgram;
                            break;
                        case 2:
                            trainingModeStrategy = new CardioTrainingMode();
                            break;
                        case 3:
                            trainingModeStrategy = new StrengthTrainingMode();
                            break;
                        default:
                            System.out.println("Invalid choice. Defaulting to Basic Training Program.");
                            trainingModeStrategy = program -> baseProgram;
                            break;
                    }

                    TrainingProgram selectedProgram = trainingModeStrategy.selectTrainingMode(baseProgram);
                    instructor.setTrainingMode(selectedTrainee, selectedProgram);
                    break;

                case 2:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select again.");
                    continue;
            }
        }
    }
}
