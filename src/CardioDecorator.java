public class CardioDecorator extends TrainingProgramDecorator{
    public CardioDecorator(TrainingProgram trainingProgram) {
        super(trainingProgram);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " with cardio exercises";
    }
}
