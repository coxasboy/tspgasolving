package org.acabativa.model;

import java.util.ArrayList;
import java.util.List;

import org.acabativa.model.actors.Scenery;
import org.acabativa.model.actors.SceneryCreator;
import org.acabativa.model.ag.Population;
import org.acabativa.model.ag.PopulationHandler;
import org.acabativa.model.ag.Solution;
import org.acabativa.util.Observable;
import org.acabativa.util.Observer;
import org.apache.log4j.Logger;

public class TSModel implements Observable{
	Logger logger = Logger.getLogger(TSModel.class);
	
	List<Observer> observers = new ArrayList<Observer>(); 
	
	int iterations = 2000;
	int numberOfCitys = 40;
	int popSize = 1000;
	
	PopulationHandler handler = null;
	
	public void stop(){
		iterations = 0;
	}
	
	public Solution getBestOne(){
		if(handler!=null){
			return handler.getBestSolution();
		}
		return null;
	}
	
	public double getBestFitness(){
		if(handler!=null){
			return handler.getBestFitness();
		}
		return -1;
	}
	
	public void start(){
		SceneryCreator creator = new SceneryCreator();
		Scenery scenery = creator.getNewScenery(numberOfCitys);
		handler = new PopulationHandler(scenery, popSize);
		Population pop = handler.createNewPop();
		for (int i = 0; i < iterations; i++) {
			logger.debug("New Iteration: " + i);
			pop = handler.envoiramentEffect(pop);
			notifyAll("New Iteration");
		}	
		logger.info("***********");
	}
	
	private  void notifyAll(String event){
		for (Observer observer : observers) {
			observer.notifyEvent(event);
		}
	}
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);		
	}

	
	
}
