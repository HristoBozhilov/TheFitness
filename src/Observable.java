public interface Observable {
    void addTrainee(Observer observer);
    void removeTrainee(Observer observer);
    void notifyObservers(String message);
}
