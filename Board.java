public class Board {
    private char[][] board = new char[3][3];
    private char player1;
    private char player2;

    public Board(char player1, char player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.initializeBoard(); // Use this.initializeBoard() to call the instance method
    }

    public void initializeBoard() { // Removed static keyword
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean spotAvailable(int spot) {
        int row = spot / 3;
        int col = spot % 3;
        return spot >= 0 && spot < 9 && board[row][col] == ' '; // Check if spot is within bounds
    }

    public void newPiece(char player, int spot) {
        int row = spot / 3;
        int col = spot % 3;
        if (spot >= 0 && spot < 9) { // Check if spot is within bounds
            board[row][col] = player;
        }
    }

    public boolean isWinner(char player) {
        // Implement your logic to check for a winner
        // Placeholder, replace with actual logic
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to get the state of the board
    public char[][] getBoardState() {
        return board;
    }
}