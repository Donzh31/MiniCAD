import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Description: the derived class line
 * Extends: items 
 * @author Ziheng Duan
 */
public class ItemLine extends Items{
	//private item line
	private Line2D line;
	
	/**
	 * Description	: the constructor of Line
	 * @param g2d  	: the graphics2D object for showing
	 * @param color	: color of ellipse
	 * @param width	: display width of the item
	 * @param x1	: x of the upper left corner of the outside rectangle
	 * @param y1	: y of the upper left corner of the outside rectangle
	 * @param x2	: width of the outside rectangle
	 * @param y2	: height of the outside rectangle
	 */
	public ItemLine(Graphics2D g2d, Color color, float width, double x1, double y1, double x2, double y2) {
		super(g2d, color, width, x1, y1, x2, y2);
		// TODO Auto-generated constructor stub
		line = new Line2D.Double(x1, y1, x2, y2);
		t_boundRect = line.getBounds2D();
	}

	/* (non-Javadoc)
	 * @see Items#drawItems()
	 */
	@Override
	public void drawItems() {
		// TODO Auto-generated method stub
		t_g2d.draw(line);
	}

	/* (non-Javadoc)
	 * @see Items#resize(java.awt.geom.Point2D, java.awt.geom.Point2D, boolean)
	 */
	@Override
	public void resize(Point2D p1, Point2D p2, boolean center) {
		// TODO Auto-generated method stub
		if(!center)
		{
			if(p1.equals(line.getP1()) || p2.equals(line.getP2()) || p1.equals(line.getP2()) || p2.equals(line.getP1()))
			{
				line.setLine(p1, p2);
				System.out.println("setline p1 p2");
			}
			else
				line.setLine(new Point2D.Double(p1.getX(), p2.getY()), new Point2D.Double(p2.getX(), p1.getY()));
		}
		else 
		{
			if(line.getP1().getX() < t_boundRect.getCenterX() && line.getP1().getY() < t_boundRect.getCenterY() || 
					line.getP2().getX() < t_boundRect.getCenterX() && line.getP2().getY() < t_boundRect.getCenterY())
				line.setLine(p1, p2);
			else
				line.setLine(new Point2D.Double(p1.getX(), p2.getY()), new Point2D.Double(p2.getX(), p1.getY()));
		}
			t_boundRect = line.getBounds2D();
	}
	
	/* (non-Javadoc)
	 * @see Items#move(java.awt.geom.Point2D)
	 */
	@Override
	public void move(Point2D endPoint) {
		// TODO Auto-generated method stub
		double moveX = endPoint.getX() - t_boundRect.getCenterX();
		double moveY = endPoint.getY() - t_boundRect.getCenterY();
		line.setLine(line.getX1() + moveX, line.getY1() + moveY, line.getX2() + moveX, line.getY2() + moveY);
		t_boundRect = line.getBounds2D();
	}

	/* (non-Javadoc)
	 * @see Items#getInfo()
	 */
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "TYPE_LINE," + t_color.getRGB() + "," + t_stockWidth + "," + (int)line.getX1() + "," + (int)line.getY1() +"," + (int)line.getX2() +"," + (int)line.getY2() + "\n";
	}


}
