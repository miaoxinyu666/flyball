package flyball;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLBoundFault;

public class tippanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -274515453205337438L;
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO �Զ����ɵķ������
		super.paintComponent(g);
		Graphics2D g2d =(Graphics2D)g;
		Image image=new ImageIcon("image/teacher.gif").getImage();
		g2d.drawImage(image, 120, 160, this);
		g2d.setColor(Color.red);
		
		Font font=new Font("����",Font.PLAIN,100);  
        g2d.setFont(font);  
        // �����
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.drawString("���㶼��������", 400, 350);
		g2d.drawString("����", 550, 550);
	}
}
