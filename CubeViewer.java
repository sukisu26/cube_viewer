/**
* 
* This program displays a CubeComponent
* @author Wanqi Su 
*/
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class CubeViewer {
	public static void main(String[] args){
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 800;
		
		final CubeComponent component = new CubeComponent();

		// Add mouse press listener
		class MousePressListener implements MouseListener{
			
			/**
			 * When the mouse is pressed, it calls the getShortPoint method
			 */
			public void mousePressed(MouseEvent event){
				int x = event.getX();
				int y = event.getY();
				component.getShortPoint(x, y);
			}
			
			/**
			 * When the mouse is released, it calls the moveTo method
			 */
			public void mouseReleased(MouseEvent event) {
				int x = event.getX();
				int y = event.getY();
				component.moveTo(x, y);
			}
			
			// Do-nothing methods
			public void mouseClicked(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
		}
		
		MouseListener listener = new MousePressListener();
		component.addMouseListener(listener);
		
		JFrame frame = new JFrame();
		frame.add(component);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("A Cube");
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}