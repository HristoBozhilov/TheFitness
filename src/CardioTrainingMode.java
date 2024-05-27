public class CardioTrainingMode implements TrainingModeStrategy {
    @Override
    public TrainingProgram selectTrainingMode(TrainingProgram baseProgram) {
        return new CardioDecorator(baseProgram);
    }
}