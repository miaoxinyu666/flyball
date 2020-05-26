package flyball;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements Runnable{

	private static final long serialVersionUID = 3943164524251087665L;
	Map map;
	JPanel contendJPanel;
	JLabel imageJLabel;
	tippanel tpTippanel=new tippanel();
//	BufferedImage stuckImage;
//	Image image=new ImageIcon("image/smail.png").getImage();
	public MyFrame() {
		// TODO 自动生成的构造函数存根
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contendJPanel=(JPanel)this.getContentPane();
		map =new Map();
		this.addKeyListener(new ListerKey(map));
		contendJPanel.add(map);
		this.setVisible(true);
		this.repaint();
		Thread t =new Thread(map);
		System.out.println(this.getName());
		t.start();
	}
	
	
	
	
	
	public static void main(String[] args) {
		MyFrame mf=new MyFrame();
		Thread thread=new Thread(mf);
		thread.start();

		
	}





	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true)
		{
			if(map.die) 
			{
				imageJLabel=new JLabel(new ImageIcon("image/teacher.gif"));
//				contendJPanel.add(imageJLabel);
				getContentPane().removeAll();
				getContentPane().repaint();
				contendJPanel.add(tpTippanel);
				this.setVisible(true);
//				contendJPanel.add(imageJLabel);
//				System.out.println("*********************************************");
//				System.out.println("*********************************************");
//				System.out.println("*********************************************");
//				System.out.println("*********************************************");
//				System.out.println("*********************************************");
//				System.out.println("*********************************************");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e1) {
//					// TODO 自动生成的 catch 块
//					e1.printStackTrace();
//				}
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
//				
		}
	}
//	@Override
//	public void paintComponents(Graphics g) {
//		// TODO 自动生成的方法存根
//		super.paintComponents(g);
//		Graphics2D g2b=(Graphics2D)g;
//		Image image=new ImageIcon("image/teacher.gif").getImage();
//		g2b.drawImage(image, 200, 200, this);
//	}

}
