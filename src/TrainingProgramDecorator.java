public abstract class TrainingProgramDecorator implements TrainingProgram{
    protected TrainingProgram trainingProgram;

    public TrainingProgramDecorator(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    @Override
    public String getDescription() {
        return trainingProgram.getDescription();
    }
}
