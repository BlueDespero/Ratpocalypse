package ratpocalypse.backend;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardManager implements KeyListener {
	
	private boolean[] keys;
	public boolean zero, one, two, three, four, five, six, seven, eight, nine;
	
	public KeyboardManager() {
		keys = new boolean[256];
	}

	public void tick()
	{
		zero = keys[KeyEvent.VK_0];
		one = keys[KeyEvent.VK_1];
		two = keys[KeyEvent.VK_2];
		three = keys[KeyEvent.VK_3];
		four = keys[KeyEvent.VK_4];
		five = keys[KeyEvent.VK_5];
		six = keys[KeyEvent.VK_6];
		seven = keys[KeyEvent.VK_7];
		eight = keys[KeyEvent.VK_8];
		nine = keys[KeyEvent.VK_9];
	}
	
	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;		
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
	}

}
