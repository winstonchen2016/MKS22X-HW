public class KnightBoard{

    private int[][] board;

    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
    }

    public String toString(){ //blank if you never called solve or when there is no solution
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[r].length; c++){
		if(board[r][c] < 10){
		    ans = ans + " " + board[r][c] + " ";
		}
		else{
		    ans = ans + board[r][c] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    public void solve(){
	solveH(0, 0, 1);
    }

    private boolean solveH(int row ,int col, int level){ // level is the # of the knight
	//System.out.println("Currently at: Row: " + row + " Col: " + col + " Lvl: " + level);
	//System.out.println(toString());
	if(level >= board.length * board[0].length){
	    board[row][col] = level;
	    return true;
	}
	//if(row >= board.length || col >= board[row].length){
	//    return false;
	//}
	if(row + 2 < board.length && row + 2 >= 0 && col + 1 < board[0].length && col + 1 >= 0 && board[row+2][col+1] == 0){
	    board[row][col] = level;
	    if(solveH(row + 2, col + 1, level + 1)){
		return true;
	    }else{
		board[row][col] = 0;
	    }
	}
	if(row + 2 < board.length && row + 2 >= 0 && col - 1 < board[0].length && col - 1 >= 0 && board[row+2][col-1] == 0){
	    board[row][col] = level;
	    if(solveH(row + 2, col - 1, level + 1)){
		return true;
	    }else{
		board[row][col] = 0;
	    }
	}
	if(row - 2 < board.length && row - 2 >= 0 && col + 1 < board[0].length && col + 1 >= 0 && board[row-2][col+1] == 0){
	    board[row][col] = level;
	    if(solveH(row - 2, col + 1, level + 1)){
		return true;
	    }else{
		board[row][col] = 0;
	    }
	}
	if(row - 2 < board.length && row - 2 >= 0 && col - 1 < board[0].length && col - 1 >= 0 && board[row-2][col-1] == 0){
	    board[row][col] = level;
	    if(solveH(row - 2, col - 1, level + 1)){
		return true;
	    }else{
		board[row][col] = 0;
	    }
	}
	if(row + 1 < board.length && row + 1 >= 0 && col + 2 < board[0].length && col + 2 >= 0 && board[row+1][col+2] == 0){
	    board[row][col] = level;
	    if(solveH(row + 1, col + 2, level + 1)){
		return true;
	    }else{
		board[row][col] = 0;
	    }
	}
	if(row + 1 < board.length && row + 1 >= 0 && col - 2 < board[0].length && col - 2 >= 0 && board[row+1][col-2] == 0){
	    board[row][col] = level;
	    if(solveH(row + 1, col - 2, level + 1)){
		return true;
	    }else{
		board[row][col] = 0;
	    }
	}
	if(row - 1 < board.length && row - 1 >= 0 && col + 2 < board[0].length && col + 2 >= 0 && board[row-1][col+2] == 0){
	    board[row][col] = level;
	    if(solveH(row - 1, col + 2, level + 1)){
		return true;
	    }else{
		board[row][col] = 0;
	    }
	}
	if(row - 1 < board.length && row - 1 >= 0 && col - 2 < board[0].length && col - 2 >= 0 && board[row-1][col-2] == 0){
	    board[row][col] = level;
	    if(solveH(row - 1, col - 2, level + 1)){
		return true;
	    }else{
		board[row][col] = 0;
	    }
	}
	return false;
    }

    public static void main(String[]args){
	KnightBoard n55 = new KnightBoard(5, 5);
	//System.out.println(n55.toString());
	n55.solve();
	System.out.println(n55.toString());
	KnightBoard n66 = new KnightBoard(6, 6);
	n66.solve();
	System.out.println(n66.toString());
	KnightBoard n11 = new KnightBoard(1, 1);
	n11.solve();
	System.out.println(n11.toString());
	KnightBoard n93 = new KnightBoard(9, 3);
	n93.solve();
	System.out.println(n93.toString());
	KnightBoard n44 = new KnightBoard(4, 4);
	n44.solve();
	System.out.println(n44.toString()); //no solution, should print blank board
    }
}
