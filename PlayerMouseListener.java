package FiveChess;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PlayerMouseListener implements MouseListener{
	private Frame f;
	private Board bd;
	private int fx;
	private int fy;
	
	PlayerMouseListener(Frame f, Board bd){
		this.f = f;
		this.bd = bd;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Object obj = e.getSource();
		JButton btn = (JButton)obj;
//		String btn_label = btn.getLabel();
//		String btn_label = btn.getText();
		String btn_label = btn.getActionCommand();
		String[] chess_xy = btn_label.split(" "); 
//		int chess_y = btn_label.indexOf(1);
		System.out.println(Arrays.toString(chess_xy));//chess_x + chess_y
		int chess_x = Integer.valueOf(chess_xy[0]).intValue();
		int chess_y = Integer.valueOf(chess_xy[1]).intValue();
		int count_step_now = bd.getStep_count();
		String color = count_step_now%2==0?"ºÚ":"°×";
		System.out.println("now_setp chess color:" + color);
		bd.setStep_count(++count_step_now);
		bd.addOneStep(chess_x, chess_y, color);
		btn.setEnabled(false);
//		btn.setBackground(color=="ºÚ"?Color.BLACK:Color.WHITE);
		
		String chess_color_path = "";
		if (color == "ºÚ"){
			chess_color_path = "I:\\javaworkspace\\day11\\src\\FiveChess\\black_chess.jpg";
		}else if (color =="°×"){
			chess_color_path = "I:\\javaworkspace\\day11\\src\\FiveChess\\white_chess.jpg";
		}
		ImageIcon con = new ImageIcon(chess_color_path);
		btn.setIcon(con);
		btn.setText(null);
		btn.setEnabled(false);
		
		bd.whoIsWinner(chess_x, chess_y, color);
//		System.out.println(Arrays.toString(bd.getBoard()));
//		btn.setEnabled(false);
		btn.removeMouseListener(this);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		String play_press_image = "I:\\javaworkspace\\day11\\src\\FiveChess\\press.jpg";
		ImageIcon con = new ImageIcon(play_press_image);
		JButton btn = (JButton)e.getSource();
		btn.setIcon(con);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		String board_exit_path = "I:\\javaworkspace\\day11\\src\\FiveChess\\board.jpg";
		ImageIcon con = new ImageIcon(board_exit_path);
		JButton btn = (JButton)e.getSource();
		btn.setIcon(con);
		
	}
	
	

}
