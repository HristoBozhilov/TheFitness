import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static Gym instance;
    private List<Instructor> instructors;

    private Gym() {
        instructors = new ArrayList<>();
    }

    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

}