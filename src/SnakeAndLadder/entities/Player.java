package SnakeAndLadder.entities;

public class Player {
    private String userName;
    private int position;

    public Player(String userName){
        this.position = 0;
        this.userName = userName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
