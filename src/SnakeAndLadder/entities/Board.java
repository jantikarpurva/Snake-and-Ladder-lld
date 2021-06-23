// This shows using Data Structure HASHMAP in implementation of Board

package SnakeAndLadder.entities;

import java.sql.SQLOutput;
import java.util.HashMap;
public class Board {

    // Since BoardEntity is under same package you dont need to import it
    // We will use hashmap to store what each cell has, like if cell 10 has snake we store <10, snake>;
    private HashMap<Integer, BoardEntity> boardCells;
    private int cellCount;
    private int boardDimension;

    public Board(int boardDimension){
        this.boardDimension = boardDimension;
        this.cellCount = boardDimension * boardDimension; // Calculate board size
        boardCells = new HashMap<Integer,BoardEntity>(); // Construct object in constructors only

        // Now we need to generate random snakes and ladders on the board
        // Since we want new snakes and ladder every time a game is create we are having this function here.
        this.addBoardEntity();
    }

    private void addBoardEntity(){
        // We need boardDimension/2 no of snake and ladder

        for(int i=0; i<(boardDimension/2); i++){
            int min = 2; // You don't want snake or ladder at 1; Also since we are manipulating min n max everytime declare inside for loop
            int max = this.cellCount - 1; // You dont want snake or ladder at 100;

            // Lets add snake first
            int start = (int) (Math.random() *(max-min+1)+min); // You want to include max as well so do +1
            max = start - 1; // You need end number lower than start coz snake takes you down
            int end = (int) (Math.random() *(max-min+1)+min);
            if(!hasBoardEntity(start) && start!=end){
                setEntity(start, new Snake(start,end));
            }

            // Lets add ladders now
            max = cellCount -1; // Since we are manipulating max, set it back
            end = end = (int) (Math.random() *(max-min+1)+min);
            max = end -1; // since you want start to be smaller, coz ladder takes you up
            start = (int) (Math.random() *(max-min+1)+min);
            if(!hasBoardEntity(start) && start!=end){
                setEntity(start, new Ladder(start,end));
            }
        }
    }

    // Check if a cell already has snake or ladder
    public boolean hasBoardEntity(int index){
        return boardCells.containsKey(index);
    }

    // Make this private so no one else should be able to add boardEntity so other player looses
    public void setEntity(int index, BoardEntity b){
        boardCells.put(index, b);
    }

    // Given a cell number, get what entity is present on that box
    public BoardEntity getEntity(int index){
        if(hasBoardEntity(index))
            return boardCells.get(index);
        return null;
    }

    // Print entire board
    public void printBoard(){
        for(int i=1;i<=cellCount;i++){
            if(hasBoardEntity(i))
                System.out.print(i+"->"+boardCells.get(i).getCoordinates()+" ");
            else
                System.out.print(i+" ");
            if(i%10 == 0)
                System.out.println("");
        }
    }

}
