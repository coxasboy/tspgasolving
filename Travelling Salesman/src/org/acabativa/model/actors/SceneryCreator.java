package org.acabativa.model.actors;

import java.util.Random;

public class SceneryCreator {
	int maxHeight = 500;
	int maxWidht = 500;
	Random randomGenerator = new Random();
		
	public Scenery getNewScenery(int numberOfCitys){
		Scenery scenery = new Scenery();
		for (int i = 0; i < numberOfCitys; i++) {
			scenery.addCity(getNewRandomCity("City: " + i));
		}		
		return scenery;
	}
	
	public City getCircleScenary(int numberOfCitys, int count){
		double pass = (Math.PI*2/numberOfCitys);
		if (count*pass>Math.PI*2){
			return null;
		}
		else{
			double x =  250 + Math.cos(pass * count)*240;
			double y =  250 + Math.sin(pass * count)*240;
			City c = new City();
			c.setName("City: " + count);
			c.setPositionX(x);
			c.setPositionY(y);
			return c;
		}
		
	}
	
	private City getNewRandomCity(String cityName){
		int posY = randomGenerator.nextInt(maxHeight);
		int posX = randomGenerator.nextInt(maxWidht);
		City c = new City();
		c.setName(cityName);
		c.setPositionX(posX);
		c.setPositionY(posY);
		return c;
	}
	
}
