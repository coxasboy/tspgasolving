package org.acabativa.model.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class SolutionSelector {

	Logger logger = Logger.getLogger(SolutionSelector.class);
	
	Population population;
	FitnessEvaluator evaluator = new FitnessEvaluator();
	Map<Double, Solution> solutionFitnessMap = new TreeMap<Double, Solution>();
	double totalSolutions = 0;
	
	public SolutionSelector(Population population) {
		super();
		this.population = population;
		generateMap();
	}
		
	private void generateMap(){
		List<Solution> solutions = new ArrayList<Solution>(population.getSolutions());
		totalSolutions = solutions.size();
		for (Solution solution : solutions) {
			solutionFitnessMap.put(evaluator.getFitness(solution), solution);
		}
	}
	
	public double evaluate(Solution solution){
		return evaluator.getFitness(solution);
	}
	
	public List<Solution> getBestSolutions(double percentage){
		int retNumber = (int)(percentage*totalSolutions);
		List<Solution> aux = new ArrayList<Solution>(solutionFitnessMap.values());
		Collections.reverse(aux);
		
		List<Solution> ret = new ArrayList<Solution>();
		for (int i = 0; i < retNumber; i++) {
			ret.add(aux.get(i));
		}
		
		return ret;
	}
	
	public List<Solution> getWorstSolutions(double percentage){
		int retNumber = (int)(percentage*totalSolutions);
		
		int ultNumber = (int)(0.3*totalSolutions);
//		logger.info("Ret number: " + retNumber);
		List<Solution> aux = new ArrayList<Solution>(solutionFitnessMap.values());
		Collections.reverse(aux);
		
		List<Solution> ret = new ArrayList<Solution>();
		for (int i = 0+ultNumber; i < retNumber+ultNumber; i++) {
			ret.add(aux.get(i));
		}
		
		return ret;
	}
	
}
