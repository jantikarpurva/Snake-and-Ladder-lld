package SnakeAndLadder.entities;

public class Ladder extends BoardEntity{

    public Ladder(int start, int end){
        super(start,end); // super can be used to call immediate parent classes constructor, this calls BoardEntity(int start, int end);
    }

    @Override
    public String getEncountered() {
        return "Yippe ! you encountered a ladder here, climb up to "+ super.getEnd();
    }

    @Override
    public String getCoordinates() {
        return "L("+ super.getEnd()+")";
    }
}
