package hangmanView;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class HangManCanvas extends Canvas{

	@Override
	public void paint(Graphics g) {
//		Graphics2D g2d = (Graphics2D) g;
//		//head
//		g2d.drawOval(130, 100, 60, 60);
//		//neck
//		g2d.drawLine(160, 161, 160, 200);
//		//left hand
//		g2d.drawLine(110, 210, 160, 200);
//		//right hand
//		g2d.drawLine(210, 210, 160, 200);
//		//body
//		g2d.drawLine(160, 200, 160, 250);
//		//left leg
//		g2d.drawLine(110, 280, 160, 250);
//		//right leg
//		g2d.drawLine(210, 280, 160, 250);
		
		//drawStandBase(g);
	}
	
	
	public void drawStandBase(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawLine(160, 161, 160, 200);
		
		super.paint(g2d);
	}
}
