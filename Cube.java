/**
* Cube class which is a cube, it has eight points.
* @author Wanqi Su 
*/
import java.awt.*;
import java.awt.geom.*;	

public class Cube {
	
	private int length; // length of the cube
	private int xmin; // the shortest x-coordinate with the mouse, when the mouse is pressed
	private int ymin; // the shortest y-coordinate with the mosue, when the mouse is pressed
	private int xtop_first; // the first square's x-coordinate
	private int ytop_first; // the first square's y-coordinate
	private int xtop_second; // the second square's x-coordinate
	private int ytop_second; // the second square's y-coordinate
	
	/**
	 * A constructor of a Cube
	 * @param len the length of the cube is passed
	 */
	public Cube(int len){
		length = len;
		xmin = 0;
		ymin = 0;
		xtop_first = 120;
		ytop_first = 70;
		xtop_second = 70;
		ytop_second = 130;
	}
	
	/**
	 * Draws the cube
	 * @param g2
	 */
	public void draw(Graphics2D g2){
		
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.RED);

		Rectangle2D.Double rectangle1 = new Rectangle2D.Double(xtop_first, ytop_first, length, length);
		g2.draw(rectangle1);

		Rectangle2D.Double rectangle2 = new Rectangle2D.Double(xtop_second, ytop_second, length, length);
		g2.draw(rectangle2);

		Line2D.Double line1 = new Line2D.Double(xtop_first, ytop_first, xtop_second, ytop_second);
		g2.draw(line1);

		Line2D.Double line2 = new Line2D.Double(xtop_first + length, ytop_first, xtop_second + length, ytop_second);
		g2.draw(line2);	

		Line2D.Double line3 = new Line2D.Double(xtop_first, ytop_first + length, xtop_second, ytop_second + length);
		g2.draw(line3);	

		Line2D.Double line4 = new Line2D.Double(xtop_first + length, ytop_first + length, xtop_second + length, ytop_second + length);
		g2.draw(line4);		
	}
	
	/**
	 * Find the shortestPoint when the mouse is pressed
	 * @param x the x-coordinate of the pressed point
	 * @param y the y-coordinate of the pressed point
	 */
	public void shortestPoint(int x, int y){
		//first square in the front
		int x1 = xtop_first;
		int y1 = ytop_first;
		int x2 = xtop_first + length;
		int y2 = ytop_first;
		int x3 = xtop_first;
		int y3 = ytop_first + length;
		int x4 = xtop_first + length;
		int y4 = ytop_first + length;
		//second square in the back
		int x5 = xtop_second;
		int y5 = ytop_second;
		int x6 = xtop_second + length;
		int y6 = ytop_second;
		int x7 = xtop_second;
		int y7 = ytop_second + length;
		int x8 = xtop_second + length;
		int y8 = ytop_second + length;
		int[] xArray = {x2, x3, x4, x5, x6, x7, x8}; // an Array that store all points' x-coordinate
		int[] yArray = {y2, y3, y4, y5, y6, y7, y8}; // an Array that store all points' y-coordinate
		
		xmin = x1;
		ymin = y1;
		double min = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));

		for(int i = 0; i < xArray.length; i++){
			double d = Math.sqrt((x-xArray[i])*(x-xArray[i]) + (y-yArray[i])*(y-yArray[i]));
			if(d < min){
				min = d;
				xmin = xArray[i];
				ymin = yArray[i];
			}
		}
	}
	
	/**
	 * Moves the Cube to the location where the mouse is released
	 * @param x the x-coordinate of the releasing point
	 * @param y the y-coordinate of the releasing point
	 */
	public void setLocation(int x, int y){
		int xmove = x - xmin; // get the horizontal distance the cube should move
		int ymove = ymin - y; // get the vertical distance the cube should move

		xtop_first = xtop_first + xmove;
		xtop_second = xtop_second + xmove;

		ytop_first = ytop_first - ymove;
		ytop_second = ytop_second - ymove;

	}
}