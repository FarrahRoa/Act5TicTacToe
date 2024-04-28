## Tic Tac Toe Game

This is a simple Tic Tac Toe game implemented in Java using Swing for the graphical user interface.

### How to Play

1. Run the `TicTacToeGUI.java` file.
2. Click on any of the empty cells to place your move.
3. The game alternates between "X" and "O" for each turn.
4. The first player to get three of their symbols in a row (horizontally, vertically, or diagonally) wins.
5. If all cells are filled without any player achieving three in a row, the game ends in a draw.
6. Click the "Reset" button to start a new game.

Features

- Graphical user interface using Swing components.
- Automatically detects and announces the winner or a draw.
- Allows resetting the game to start over.

 Technical Details

The game is implemented using Java and Swing. Here's a brief overview of the classes:

- `TicTacToeGUI`: Main class that sets up the game window, board, and user interface components. It handles user input and game logic.
- `Board`: Represents the game board and provides methods to check for winning conditions and reset the board.

Dependencies

This game does not require any external dependencies. It's built using standard Java libraries.

 Development Environment

- Java Development Kit (JDK): Ensure you have JDK installed to compile and run the Java code.
- Integrated Development Environment (IDE): You can use any Java IDE like IntelliJ IDEA, Eclipse, or NetBeans to work with the codebase.

