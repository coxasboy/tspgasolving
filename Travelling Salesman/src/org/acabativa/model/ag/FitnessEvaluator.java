package org.acabativa.model.ag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acabativa.model.actors.City;
import org.apache.log4j.Logger;

public class FitnessEvaluator {
	Logger logger = Logger.getLogger(FitnessEvaluator.class);
	
	Map<DistanceStore, Double> storeMap = new HashMap<DistanceStore, Double>();
	
	private double calculateDistance(City cityA, City cityB){
		double xDiference = cityA.getPositionX() - cityB.getPositionX();
		double yDiference = cityA.getPositionY() - cityB.getPositionY();
		double squareX = Math.pow(xDiference, 2);
		double squareY = Math.pow(yDiference, 2);
		double ret = Math.sqrt(squareX+squareY);
		return ret;
	}
	
	private double getDistance(City cityA, City cityB){
		return calculateDistance(cityA, cityB);
//		DistanceStore store = new DistanceStore(cityA, cityB);
//		if(storeMap.containsKey(store)){
//			return storeMap.get(store);
//		}
//		else{
//			double distance = calculateDistance(cityA,cityB);
//			storeMap.put(store,distance);
//			return distance;
//		}		
	}
	
	public double getFitness(Solution solution){
		List<City> citys = solution.getItinerary();
		double total = 0;
		City lastOne = null;
		for (City city : citys) {
			if(lastOne!=null){
				total += getDistance(lastOne, city);
			}
			lastOne = city;
		}
		if(citys.size()>1){
			total += getDistance(lastOne, citys.get(0));
		}
		
		return 1/total;
	}
	
}
