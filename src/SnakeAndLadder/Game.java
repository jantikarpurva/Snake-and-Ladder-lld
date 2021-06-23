package SnakeAndLadder;

import SnakeAndLadder.entities.Board;
import SnakeAndLadder.entities.BoardEntity;
import SnakeAndLadder.entities.Player;
import SnakeAndLadder.services.DiceService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    Board gameBoard;  // Generate board
    private Queue<Player> players;
    private Queue<Player> winners;
    public int diceCount; // Number of dice
    private final int boardSize; // Board size for eg 10*10 = 100

    Game(int boardDimension, int diceCount){
        this.diceCount=diceCount;
        this.boardSize = boardDimension*boardDimension;
        gameBoard = new Board(boardDimension);
        players = new LinkedList<>();
        winners = new LinkedList<>();
    }

    public void launchGame(){
        gameBoard.printBoard();
        int winnerCount =0;

        while(players.size()>1){
            Player currPlayer = players.poll();
            int finalPosition=0;
            if(rollItsYourTurn(currPlayer.getUserName())) {
                int diceValue = DiceService.rollDice(diceCount);
                System.out.println("You got " + diceValue);
                finalPosition = makeMove(diceValue, currPlayer);
            }
            if(checkWinner(finalPosition)){
                winnerCount++;
                System.out.println("Winner " + winnerCount + " "+ currPlayer.getUserName());
                winners.add(currPlayer);
            }
            else{
                players.add(currPlayer);
            }
        }

        winners.add(players.poll());
        printWinners();
    }

    private boolean rollItsYourTurn(String userName){
        System.out.println(" ");
        System.out.println(userName+ " press r to roll dice ");
        Scanner sc = new Scanner(System.in);
        String diceCharacter = sc.next();
        while (diceCharacter.charAt(0)!='r'){
            System.out.println("Enter r to roll dice");
            diceCharacter = sc.next();
        }
        return true;
    }

    private int makeMove(int diceValue, Player currPlayer){
        int prevPosition = currPlayer.getPosition();
        int finalPosition = currPlayer.getPosition()+diceValue;

        if(gameBoard.hasBoardEntity(finalPosition)){
            BoardEntity be = gameBoard.getEntity(finalPosition); // Here we make a reference variable of abstract class, now it doesn't matter what comes in as long as it is of BoardEntity type
            System.out.println(be.getEncountered());
            finalPosition = be.getEnd();
        }

        if(finalPosition>boardSize){
            System.out.println("Oops invalid move ! Try in next round");
        }
        else{
            currPlayer.setPosition(finalPosition);
            printMove(currPlayer, prevPosition);
        }
        return currPlayer.getPosition();
    }

    private void printMove(Player currPlayer, int prevPosition){
        System.out.println("Player " + currPlayer.getUserName() + " from "+prevPosition+ " to "+currPlayer.getPosition());
    }

    public void printWinners(){
        int i=1;
        for (Player player : winners){
            System.out.println("On position " +i+ " "+ player.getUserName());
            i++;
        }
    }

    private boolean checkWinner(int finalPositionOnBoard){
        return finalPositionOnBoard == boardSize;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public void addPlayers(Player p){
        if(players.size()!=4)
            players.add(p);
        else
            System.out.println("Sorry only 4 players can be added");
    }

    public Queue<Player> getWinners() {
        return winners;
    }

    public void setWinners(Queue<Player> winners) {
        this.winners = winners;
    }

}
