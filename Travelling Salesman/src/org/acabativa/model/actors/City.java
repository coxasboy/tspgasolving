package org.acabativa.model.actors;

import java.awt.Point;

public class City {

	String name;
	double positionX;
	double positionY;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPositionX() {
		return positionX;
	}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public double getPositionY() {
		return positionY;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	public Point getPoint(){
		return new Point((int)positionX, (int)positionY);
	}
	
	@Override
	public String toString() {
		return "City [name=" + name + ", positionX=" + positionX
				+ ", positionY=" + positionY + "]";
	}
	
	
	
	
}
