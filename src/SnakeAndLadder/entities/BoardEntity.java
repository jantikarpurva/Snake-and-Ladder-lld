package SnakeAndLadder.entities;

public abstract class BoardEntity {

    // This is abstract class so it has methods which have to be implemented in child class
    // Also methods whose implementation will remain same through out all child classes

    // Declare variables as private so no other class can access it and abuse it ( Encapsulation )
    // private variables can only be exposed by getters and setters
    private int start;
    private int end;

    // We need constructor to initialize the attributes
    public BoardEntity(int start, int end){
        this.end = end;
        this.start = start;
    }

    // Methods declared as abstract have to be implemented in child class
    // To get snake or ladder encountered message
    public abstract String getEncountered();

    // To return coordinates of snake or ladder
    public abstract String getCoordinates();

    // Use getters and setters to access start and end
    // Reason why we are implementing getters and setters here is coz all child classes implementing this class will have start and end
    // Since the implementation of getters and setters will be same this can be implemented in abstract class it self.

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

}
