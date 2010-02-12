package org.acabativa.view.drawer;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class FitnessDrawer implements Drawer{

	int count = 0;
	private static final int SHAPE_SIZE = 6;
	List<Point> points = new ArrayList<Point>();
	
	public void draw(Graphics2D g2d, double fitness) throws IllegalArgumentException{
		g2d.drawString("Best fitness: " + fitness, 20, 20 );
		if(count%100==0){
			addPoint(g2d, fitness);
		}
		createAndDrawShape(g2d);
		createRectangleAndDrawShape(g2d);
		count++;
	}
	
	private void addPoint(Graphics2D g2d, double fitness){
		int value = (int) (fitness*100000);
		points.add(new Point(0+(count/10),50+(value*2)));
	}
	
	private void createRectangleAndDrawShape(Graphics2D g2d){
		Shape shape = new Rectangle(0,50,300,200);
		g2d.draw(shape);		
	}
	
	private void createAndDrawShape(Graphics2D g2d){
		for (Point point : points) {
			Shape shape = new Ellipse2D.Double((int)point.getX()-(SHAPE_SIZE/2),(int)point.getY()-(SHAPE_SIZE/2),SHAPE_SIZE,SHAPE_SIZE);
			g2d.fill(shape);
		}		
	}
	
}
