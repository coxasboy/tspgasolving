package org.acabativa.controller;

import org.acabativa.model.TSModel;
import org.acabativa.view.BestSolutionView;
import org.acabativa.view.FitnessView;

public class TSControllerImpl implements TSController{
	
	TSModel model;
	BestSolutionView bestSolutionView;
	FitnessView fitnessView;
		
	public TSControllerImpl(TSModel model) {
		super();
		this.model = model;
		this.bestSolutionView = new BestSolutionView(this, model);
		this.fitnessView = new FitnessView(this, model);
		start();	
	}	

	@Override
	public void start() {
		model.start();
	}

	@Override
	public void stop() {
		model.stop();
	}
	
}
