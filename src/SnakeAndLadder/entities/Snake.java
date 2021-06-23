package SnakeAndLadder.entities;

public class Snake extends BoardEntity {

    public  Snake(int start, int end){
        super(start, end); // super can be used to call immediate parent classes constructor, this calls BoardEntity(int start, int end);
    }

    @Override
    public String getEncountered(){
        return "Oops ! you encountered a snake, go back to "+ super.getEnd();
    }

    @Override
    public String getCoordinates() {
        return "S("+ super.getEnd() +")";
    }
}
