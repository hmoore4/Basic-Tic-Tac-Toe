/*Hunter Moore
7/3/20
Most basic iteration of Tic Tac Toe. Standard rules in play.
*/

//import java.util.InputMismatchException;
//import java.util.Scanner;

public class BasicGame {
    private Character[][] board = new Character[3][3];
    private char currentPlayerMark = 'x';

    public BasicGame(){

    }
    public void intializeBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = '-';
            }
        }
    }

    public void printBoard(){
        System.out.println("------------");
        for(int i = 0; i < 3; i++){
            System.out.print("|");

            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("------------");

    }

    public boolean isBoardFull(int moves){
        if(moves == 9)
            return true;
        else
            return false;
    }

    public boolean checkForWin(){
        if(checkRowsForWin())
            return true;
        else if(checkColumnsForWin())
            return true;
        else if(checkDiagnolsForWin())
            return true;
        else{
            return false;
        }
    }

    private boolean checkRowsForWin(){
        for(int i = 0; i < 3; i++){
            if(checkRowCol(board[i][0], board[i][1], board[i][2])){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin(){
        for(int j = 0; j < 3; j++){
            if(checkRowCol(board[0][j], board[1][j], board[2][j])){
                return true;
            }
        }
        return false;    
    }

    private boolean checkDiagnolsForWin(){
            if(checkRowCol(board[0][0], board[1][1], board[2][2])){
                return true;
            }
            else if(checkRowCol(board[0][2], board[1][1], board[2][0])){
                return true;
            }
        
            else{
                 return false;       
            }
    }
    private boolean checkRowCol(char c1, char c2, char c3){
        if(c1 == c2 && c1 == c3 && c2== c3 && c1 != '-' && c2 != '-' && c3!= '-'){
            return true;
        }
        else{
            return false;
        }
    }

    public void changePlayer(){
        if(currentPlayerMark == 'x')
            currentPlayerMark = 'o';
        else
            currentPlayerMark = 'x';
    }

    public boolean placeMark(int row, int column){
        if(board[row][column] == '-'){
            board[row][column] = currentPlayerMark;
            return true;
        }
        return false;
    }

   /* public boolean getInput() throws InputMismatchException, ArrayIndexOutOfBoundsException{
        try{
            Scanner scan = new Scanner(System.in);
            int row;
            int col;
            row = scan.nextInt() - 1;
            col = scan.nextInt() - 1;
        }
            catch(Exception InputMismatchException){
                System.out.println("Please enter integer between 1-3.");
                return false;
            }
           // catch(Exception arrayIndexOutOfBoundsException){
            //    System.out.print("Please enter integer between 1-3.");
            //}
        //scan.close();
        return true;

            }*/

    public char getCurrentPlayerMarker(){
        return currentPlayerMark;
    }
}