import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToeGUI extends JFrame {

    private static final long serialVersionUID = -5034718198692604252L;
    JButton[] boardButtons = new JButton[9];
    JButton resetButton = new JButton("Reset");
    JFrame frame = new JFrame("Tic Tac Toe");

    Board board = new Board('X', 'O');
    char currentPlayer = 'X';

    public TicTacToeGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        initialise(); // Call initialise method
        frame.pack(); // Pack the frame to set the appropriate size
        frame.setVisible(true); // Set visibility after components are added
    }

    private void initialise() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gameBoard = new JPanel(new GridLayout(3, 3));

        frame.add(mainPanel);

        gameBoard.setPreferredSize(new Dimension(500, 500));

        mainPanel.add(gameBoard, BorderLayout.NORTH);
        mainPanel.add(resetButton, BorderLayout.SOUTH); // Add reset button to the bottom

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        // Initialise all the buttons
        for (int i = 0; i < 9; i++) {
            boardButtons[i] = new JButton();
            boardButtons[i].setBackground(Color.BLACK);
            boardButtons[i].setText("");
            boardButtons[i].setVisible(true);

            gameBoard.add(boardButtons[i]);
            boardButtons[i].addActionListener(new MyActionListener(i));
            boardButtons[i].setFont(new Font("Tahoma", Font.BOLD, 100));
        }
    }

    // Listen for when the buttons are clicked
    private class MyActionListener implements ActionListener {
        private int spot;

        public MyActionListener(int spot) {
            this.spot = spot;
        }

        public void actionPerformed(ActionEvent action) {
            if (board.spotAvailable(spot)) {
                // Place X or O in the cell when clicked
                board.newPiece(currentPlayer, spot);
                JButton clickedButton = (JButton) action.getSource();
                clickedButton.setText(Character.toString(currentPlayer));

                // Check if there's a winner after each turn
                if (isWinner(currentPlayer)) {
                    gameOver(currentPlayer);
                } else {
                    // Switch player
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    // Update the title to show whose turn it is
                    frame.setTitle("Tic Tac Toe - Player " + currentPlayer + "'s Turn");
                }
            }
        }
    }

    // Check if there's a winner
    private boolean isWinner(char player) {
        char[][] boardState = board.getBoardState();
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (boardState[row][0] == player && boardState[row][1] == player && boardState[row][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int col = 0; col < 3; col++) {
            if (boardState[0][col] == player && boardState[1][col] == player && boardState[2][col] == player) {
                return true;
            }
        }
        // Check diagonals
        if (boardState[0][0] == player && boardState[1][1] == player && boardState[2][2] == player) {
            return true;
        }
        if (boardState[0][2] == player && boardState[1][1] == player && boardState[2][0] == player) {
            return true;
        }
        return false;
    }

    // Reset the game
    private void resetGame() {
        // Clear the board
        for (int i = 0; i < 9; i++) {
            boardButtons[i].setText("");
        }
        board.initializeBoard(); // Reset the internal game board
        currentPlayer = 'X'; // Reset the player turn
        frame.setTitle("Tic Tac Toe - Player " + currentPlayer + "'s Turn"); // Reset the title
    }

    // When the game is over, display any winners in the title
    public void gameOver(char winner) {
        for (int i = 0; i < 9; i++) {
            boardButtons[i].setEnabled(false);
        }

        if (winner == 'X') {
            JOptionPane.showMessageDialog(frame, "Player 1 wins!");
            frame.setTitle("Tic Tac Toe: Player 1 WINS!");
        } else if (winner == 'O') {
            JOptionPane.showMessageDialog(frame, "Player 2 wins!");
            frame.setTitle("Tic Tac Toe: Player 2 WINS!");
        } else {
            JOptionPane.showMessageDialog(frame, "It's a draw.");
            frame.setTitle("Tic Tac Toe: It's a DRAW!");
        }
    }

    public static void main(String[] args) {
        TicTacToeGUI game = new TicTacToeGUI();
    }
}