import java.util.Scanner;

public class PlayGame{
    public static void main(String args []){
        int moves = 0;
        Scanner scan = new Scanner(System.in);
        BasicGame newGame = new BasicGame();
        newGame.intializeBoard();
        System.out.println("Tic Tac Toe!");
        System.out.println("");
        System.out.println("Current board:");
        newGame.printBoard();
        int row;
        int col;

        while(!newGame.checkForWin()){    
            moves++;
            System.out.println("Player " + newGame.getCurrentPlayerMarker() + " select which row and column you want to place your mark on.");
            row = scan.nextInt() - 1;
            col = scan.nextInt() - 1;
            if(row < 0 || row > 2 || col < 0 || col > 2){
                System.out.println("Please enter a coordinate within the dimensions of the board (1-3)");
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;
            }
            while(newGame.placeMark(row, col) == false){
                System.out.println("Spot already taken. Try again.");
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;
            }

            if(newGame.isBoardFull(moves)){
                newGame.printBoard();
                System.out.println("The game was a tie!");
                break;
            }
            newGame.printBoard();
            newGame.changePlayer();
        }
        newGame.changePlayer();

        if(!newGame.isBoardFull(moves)){
            System.out.println("Player " + newGame.getCurrentPlayerMarker() + " wins!");
        }
    }
}