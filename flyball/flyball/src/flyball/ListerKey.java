package flyball;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListerKey implements KeyListener{

	Map map=new Map();
	ListerKey(Map map)
	{
		this.map=map;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		int key=e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_RIGHT:
			map.dir=1;
			break;
		case KeyEvent.VK_LEFT:
			map.dir=-1;
			break;
		case KeyEvent.VK_UP:
			map.fly=true;
			map.ballMove=new move(map);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		map.dir=0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}

}
