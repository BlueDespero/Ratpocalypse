package ratpocalypse.backend;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import ratpocalypse.backend.states.StateMenager;

public class MouseManager implements java.awt.event.MouseListener, MouseMotionListener {

	private boolean leftpressed, rightpressed;
	private int MouseX, MouseY;
	private Handler handler;
	
	public MouseManager(Handler handler) {
		this.handler=handler;
	}
	
	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		MouseX = e.getX();
		MouseY = e.getY();
	}

	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			StateMenager.getState().OnClick(MouseX, MouseY);
		}
		else
			handler.getGame().getGvmanager().selectedUnit=0;
	}

	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
			leftpressed = true;
		if(e.getButton()==MouseEvent.BUTTON3)
			rightpressed = true;	}

	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
			leftpressed = false;
		if(e.getButton()==MouseEvent.BUTTON3)
			rightpressed = false;	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isLeftpressed() {
		return leftpressed;
	}

	public void setLeftpressed(boolean leftpressed) {
		this.leftpressed = leftpressed;
	}

	public boolean isRightpressed() {
		return rightpressed;
	}

	public void setRightpressed(boolean rightpressed) {
		this.rightpressed = rightpressed;
	}

	public int getMouseX() {
		return MouseX;
	}

	public void setMouseX(int mouseX) {
		MouseX = mouseX;
	}

	public int getMouseY() {
		return MouseY;
	}

	public void setMouseY(int mouseY) {
		MouseY = mouseY;
	}
}
