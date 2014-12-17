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
		start();	
	}	
	
	public void iterate(){
		model.reset();
		if(this.bestSolutionView!=null && this.fitnessView!=null){
			this.bestSolutionView.setVisible(false);
			this.fitnessView.setVisible(false);
			
		}
		this.bestSolutionView = new BestSolutionView(this, model);
		this.fitnessView = new FitnessView(this, model);
		model.start();		
		
	}

	@Override
	public void start() {
		while(true){
			iterate();
			while(!model.isEnd()){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void stop() {
		model.stop();
	}
	
}
