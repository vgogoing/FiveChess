package FiveChess;

import java.awt.Button;
import java.awt.Frame;

public class Board {
	
	public int x;
	public int y;
	public String[][] board;
	public int step_count;
	

	Board(int x, int y){
		this.x = x;
		this.y = y;
		this.board = new String[x][y];
		this.step_count = 0;
	}
	
	public int getStep_count() {
		return step_count;
	}

	public void setStep_count(int step_count) {
		this.step_count = step_count;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}

	public void addOneStep(int x, int y, String color){
		
		this.board[x][y] = color;
	}
	
	public void whoIsWinner(int x, int y, String color){
		//横排5个  暂时不考虑边界问题  
		//double dir_flag;//12 1.5 3 4.5 6 7.5  9  10.5  表方向  方向check太高难度 先用笨方法
		String[][] board = this.getBoard();
		int board_x =  board.length;
		int board_y =  board[0].length;
//		int[] dir_flag_9 = new int[4];
//		int[] dir_flag_3 = new int[4];
		int row_count = 1;

		
		///----------------------------------横向判断
		for (int a=1;a<6;a++){
			if (y-a>-1 && board[x][y-a] == color){
				row_count ++;
			}else {
				break;
			}
		}
		for (int b=1;b<6;b++){
			if (y+b<board_y && board[x][y+b] == color){
				row_count ++;
			}else {
				break;
			}
		}
		checkWin(row_count,color);		
		///---------------------------------竖向判断
		row_count = 1;
		for (int i=1;i<6;i++){
			if (x-i>-1 && board[x-i][y] == color){
				row_count ++;
			}else {
				break;
			}
		}
		
		for (int i=1;i<6;i++){
			if (x+i<board_x && board[x+i][y] == color){
				row_count ++;
			}else {
				break;
			}
		}
		checkWin(row_count,color);
		
		//-------------------------------左斜上 +右斜下判定
		row_count = 1;
		for (int a=1;a<6;a++){
			if (x-a >-1 && y-a>-1 && board[x-a][y-a] == color){
				row_count ++;
			}else{
				break;
			}
		} 
		
		for (int b=1;b<6;b++){
			if (x+b<board_x && y+b<board_y && board[x+b][y+b] == color){
				row_count ++;
			}else{
				break;
			}
		}
		checkWin(row_count,color);
		
		//-------------------------------右协商+左斜下验证
		row_count = 1;
		for (int a=1;a<6;a++){
			if (x-a>-1 && y+a<board_y && board[x-a][y+a] == color){
				row_count ++;
			}else{
				break;
			}
		} 
		
		for (int b=1;b<6;b++){
			if (x+b<board_x && y-b>-1 && board[x+b][y-b] == color){
				row_count ++;
			}else{
				break;
			}
		}
		checkWin(row_count,color);
	}
	
	public void checkWin(int row_count, String color){
		if (row_count>=5){
			String win_color = color + "win  sleep5s exit";
			System.out.println(win_color);
			Frame f = new Frame("you win");
			f.add(new Button(win_color));
			f.setSize(100, 100);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
}
