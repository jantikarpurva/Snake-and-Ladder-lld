# Snake-and-Ladder-lld

Design the game of Snake & Ladder
----------------------------------
1) Create a Snake and Ladder application.
2) The application should take input n from the user.
3) The game should have a board size of n x n.
4) There should be n snakes and n ladders placed randomly in the board.
5) Each snake will have its head at some number and its tail at a smaller number.
6) Each ladder will have its start position at some number and end position at a larger number.
7) There can be multiple players in the game.

Rules
-------
1) The board has numbers from 1 to n^2.
2) The players will make there move turn-by-turn.
3) The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
4) Each player has a piece which is initially kept outside the board (i.e., at position 0).
5) Each player rolls the dice when their turn comes.
6) Based on the dice value, the player moves their piece forward that number of cells. Ex: If the dice value is 4 and the player is at position 7, the player will move to position 11 (7+4).
7) A player wins if he reached the last cell in the board.
8) Whenever a player ends up at a cell with the head of the snake, the player should go down to the cell that has the tail of that snake.
9) Whenever a player ends up at a cell with the start of the ladder, the player should go up to the cell that has the end of that ladder.
10) The game should continue till there are at least 2 players still playing to win.
11) After the dice roll, if a piece is supposed to move outside position 100, it does not move.
12) Snakes and Ladders do not create a cycle.

Future Scope
------------
1) The game can be played by more than one dices. (i.e. if there are two dices then the numbers from 2 to 12 will be generated).
2) On getting a 6, you get another turn and on getting 3 consecutive 6s, all the three of those get cancelled.

Class Diagram
-------------

