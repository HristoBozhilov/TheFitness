public class StrengthTrainingMode implements TrainingModeStrategy {
    @Override
    public TrainingProgram selectTrainingMode(TrainingProgram baseProgram) {
        return new StrengthTrainingDecorator(baseProgram);
    }
}