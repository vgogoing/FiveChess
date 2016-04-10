package FiveChess;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int width = 16;
		int heigth = 16;
		Board bd = new Board(heigth,width);
		Frame f = new Frame("Îå×ÓÆå");
		Panel p = new Panel();
		PlayerMouseListener ml = new PlayerMouseListener(f,bd);
		
		String board_image_path = "I:\\javaworkspace\\day11\\src\\FiveChess\\board.jpg";
		
		for (int i=0;i<bd.board.length;i++){
			for (int k=0;k<bd.board[0].length;k++){
				JButton btn = new JButton(i+" "+k);
				ImageIcon con = new ImageIcon(board_image_path);
				btn.setActionCommand(i+" "+k);
				btn.setBorderPainted(false);
				btn.setText(null);
				btn.setIcon(con);
				btn.addMouseListener(ml);
				p.add(btn);
			}
		}
		
		
		p.setLayout(new GridLayout(heigth,width));
		f.add(p);
		
		f.setSize(400, 400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
	}
	
}
