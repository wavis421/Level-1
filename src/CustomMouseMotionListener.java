import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CustomMouseMotionListener implements MouseMotionListener {

	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse dragged, x = " + e.getX() + " y = " + e.getY());
	}

	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse moved, x = " + e.getX() + " y = " + e.getY());
	}
}
