import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;

public class Board {
    private int[][] board;

    // create a new board to use for the game
    public Board() {
        board = new int[6][7];
    }

    // make a move based on a given column and player; returns if successful or not
    // public boolean makeMove(int col, int player) {
    //     if (board[0][col] != 0) {
    //         return false;
    //     }
    //     for (int i = 5; i >= 0; i--) {
    //         if (board[i][col] == 0) {
    //             board[i][col] = player;
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // make a move based on a given column and player; returns the row
    public int makeMove(int col, int player) {
        if (board[0][col-1] != 0) {
            return -1;
        }
        for (int i = 5; i >= 0; i--) {
            if (board[i][col-1] == 0) {
                board[i][col-1] = player;
                return i;
            }
        }
        return -1;
    }

    // check if there is a winner
    public String checkWinner() {
        int rows = board.length;
        int cols = board[0].length;
        int winner = 0;
        ArrayList<Integer> count = new ArrayList<Integer>();

        // horizontal check
        // 6 times
        for (int i = 0; i < rows; i++) {
            // 4 times
            for (int j = 0; j < cols - 3; j++) {
                count.removeAll(count);
                for (int x = 0; x < 4; x++) {
                    if (board[i][j + x] != 0) {
                        count.add(board[i][j + x]);
                    }
                }
                if (count.size() == 4 && count.get(0) == count.get(1) && count.get(1) == count.get(2) && count.get(2) == count.get(3))
                    winner = count.get(0);
            }
        }

        // vertical check
        // 7 times
        for (int i = 0; i < cols; i++) {
            // 3 times
            for (int j = 0; j < rows - 3; j++) {
                count.removeAll(count);
                for (int x = 0; x < 4; x++) {
                    if (board[j + x][i] != 0) {
                        count.add(board[j + x][i]);
                    }
                }
                if (count.size() == 4 && count.get(0) == count.get(1) && count.get(1) == count.get(2) && count.get(2) == count.get(3))
                    winner = count.get(0);
            }
        }

        // check diagonal top left -> SE
        // 3 times
        for (int i = 0; i < rows - 3; i++) {
            // 4 times
            for (int j = 0; j < cols - 3; j++) {
                count.removeAll(count);
                for (int x = 0; x < 4; x++) {
                    if (board[x + i][x + j] != 0) {
                        count.add(board[x + i][x + j]);
                    }
                }
                if (count.size() == 4 && count.get(0) == count.get(1) && count.get(1) == count.get(2) && count.get(2) == count.get(3))
                    winner = count.get(0);
            }
        }

        // check diagonal top right -> SW
        int b = 6;
        for (int a  = 0; a < rows - 3; a++) {
            b = 6;
            while (b > cols - 5) {
                count.removeAll(count);
                for (int x = 0; x < 4; x++) {
                    if (board[a+x][b-x] != 0) {
                        count.add(board[a+x][b-x]);
                    }
                }
                if (count.size() == 4 && count.get(0) == count.get(1) && count.get(1) == count.get(2) && count.get(2) == count.get(3))
                    winner = count.get(0);
                b--;
            }
        }

        // return the winner
        if (winner != 0) {
            if (winner == 1)
                return "Player 1";
            else
                return "Player 2";
        }
        // check if there is a tie by checking if top row is full
        for (int i = 0; i < 7; i++) {
            // if not full and no winner
            if (board[0][i] == 0)
                return "None";
        }

        return "Tie";
    }

    public void draw(Graphics g){

        g.setColor(Color.LIGHT_GRAY);
        for(int y = 50; y < 380; y += 55){
            for(int x = 450; x < 800; x += 55)
                g.fillRoundRect(x, y, 50, 50, 20, 20);
        }

        g.setColor(Color.darkGray);
        for(int y = 56; y < 380; y += 55){
            for(int x = 456; x < 825; x += 55)
                g.drawRoundRect(x, y, 38, 38, 20, 20);
        }
    }
}