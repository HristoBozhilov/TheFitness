public class StrengthTrainingDecorator extends TrainingProgramDecorator{
    public StrengthTrainingDecorator(TrainingProgram trainingProgram) {
        super(trainingProgram);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " with strength training exercises";
    }
}
