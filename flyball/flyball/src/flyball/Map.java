package flyball;

import java.util.Random;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;



public class Map extends JPanel implements Runnable{

	private static final long serialVersionUID = -4840513689085126103L;
	boolean arr2D[][]= new boolean[11][50];
	
	
	BufferedImage stuckImage;
//	JFrame myFrame;
//	JPanel contendJPanel;
	Image image=new ImageIcon("image/smail.png").getImage();
	Image boatImage=new ImageIcon("image/boat.png").getImage();
	Image ballImage=new ImageIcon("image/ball.png").getImage();
	Image teacherImage=new ImageIcon("image/teacher.gif").getImage();
	int boatlocation;
	int dir=0;
	int ballx,bally;
	boolean fly=false;
	boolean first=true;
	move ballMove;
	boolean die=false;
	
	
	public Map() {

		Random r =new Random(1);
		
		for(int x=0;x<arr2D.length-1;x++)
		{
			for(int y=0;y<arr2D[x].length;y=y+4)
			{
//				int temp=r.nextInt(2);
//				if(temp==1)
					arr2D[x][y]=true;
			}
		}
		
		
		
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自动生成的方法存根
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;

		
		for(int x=0;x<arr2D.length;x++)
			{
				for(int y=0;y<arr2D[x].length;y++)
				{
					if(arr2D[x][y])
					{
						g2d.drawImage(image, y*30, x*30, this);
					}
						
				}
			}
		
		if(first)
		{
			boatlocation=this.getWidth()/2-boatImage.getWidth(null)/2;
			first=false;
		}
		
		switch (dir) {
		case -1:
			boatlocation -=5;
			break;
		case 1:
			boatlocation +=5;
			break;
		default:
			break;
		}
		if(!fly)
		{
			g2d.drawImage(ballImage, boatlocation+boatImage.getWidth(null)/2-10,this.getHeight()-50, this);
			if(die)
			{
//				g2d.drawImage(teacherImage, 200, 200, this);
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO 自动生成的 catch 块
//					e.printStackTrace();
//				}
			}
		}
		
		else {
			ballMove.fly();
			g2d.drawImage(ballImage, ballx,bally, this);
		}
		g2d.drawImage(boatImage, boatlocation, this.getHeight()-30, this);
		}
	
	
		@Override
		public void run() {
			// TODO 自动生成的方法存根
			int n=0;
			while (true)
			{
			this.repaint();
			
			System.out.println("刷新"+n+++"次");
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}	
			}
			
		}
		
		
	
		
	
	

}
