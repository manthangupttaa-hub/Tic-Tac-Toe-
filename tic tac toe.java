import java.util.Scanner;

public class tic tac toe {
    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // initialize board
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);

            System.out.println("Player " + player + " enter row and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // check valid move
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {

                board[row][col] = player;

                gameOver = haveWon(board, player);

                if (gameOver) {
                    printBoard(board);
                    System.out.println("Player " + player + " has won!");
                } else {
                    // switch player
                    player = (player == 'X') ? 'O' : 'X';
                }

            } else {
                System.out.println("Invalid move. Try again!");
            }
        }

        scanner.close();
    }

    public static boolean haveWon(char[][] board, char player) {
git
        // rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player &&
                board[row][1] == player &&
                board[row][2] == player) {
                return true;
            }
        }

        // columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player &&
                board[1][col] == player &&
                board[2][col] == player) {
                return true;
            }
        }

        // diagonals
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] board) {

        for (int row = 0; row < 3; row++) {
            System.out.println(
                board[row][0] + " | " +
                board[row][1] + " | " +
                board[row][2]
            );
            if (row < 2) {
                System.out.println("--+---+--");
            }
        }
    }
}