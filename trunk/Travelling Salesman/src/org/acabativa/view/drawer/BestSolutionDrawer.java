package org.acabativa.view.drawer;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.List;

import org.acabativa.model.TSModel;
import org.acabativa.model.actors.City;
import org.acabativa.model.ag.Solution;

public class BestSolutionDrawer implements Drawer{

	private static final int SHAPE_SIZE = 6;
	
	public void draw(Graphics2D g2d, Solution bestSolution) throws IllegalArgumentException{
		Solution solution = bestSolution;
		List<City> citys = solution.getItinerary();
		City lastOne = null;
		for (City city : citys) {
			createAndDrawShape(g2d, city.getPoint());
			if(lastOne!=null){
				drawLine(g2d, lastOne, city);
			}
			lastOne = city;
		}
		if(citys.size()>0){
			drawLine(g2d, lastOne, citys.get(0));
		}
	}
	
	private void drawLine(Graphics2D g2d, City cityA, City cityB){
		Point start = cityA.getPoint();
		Point end = cityB.getPoint();
		g2d.draw(new Line2D.Double(
				new Point2D.Double(start.getX(), start.getY()),
				new Point2D.Double(end.getX(), end.getY())
		));	
	}
	
	private void createAndDrawShape(Graphics2D g2d, Point point){
		Shape shape = new Ellipse2D.Double((int)point.getX()-(SHAPE_SIZE/2),(int)point.getY()-(SHAPE_SIZE/2),SHAPE_SIZE,SHAPE_SIZE);
		g2d.fill(shape);
	}
	
}
