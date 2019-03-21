/**

* This is the Cube Component which contains a cube
* @author Wanqi Su 
*/
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class CubeComponent extends JComponent{
	
	private Cube cube;
	private static final int DEFAULT_LENGTH = 200; // the length of the cube
	
	/**
	 *  a constructor of CubeComponent
	 */
	public CubeComponent() {
		cube = new Cube(DEFAULT_LENGTH);
	}

	/**
	 * draw the cube
	 */
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		cube.draw(g2);
	}
	
	/**
	 * Moves the cube and repaint it
	 * @param x the x-coordinate that the mouse releases
	 * @param y the y-coordinate that the mouse releases
	 */
	public void moveTo(int x, int y){
		cube.setLocation(x, y);
		repaint();  
	}
	
	/**
	 * Finds the point which has the shortest distance with the mouse
	 * @param x the x-coordinate that the mouse presses
	 * @param y the y-coordinate that the mouse presses
	 */
	public void getShortPoint(int x, int y){
		cube.shortestPoint(x, y);
	}
}