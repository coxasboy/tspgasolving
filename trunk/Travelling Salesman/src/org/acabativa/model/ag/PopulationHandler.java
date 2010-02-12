package org.acabativa.model.ag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.acabativa.model.actors.Scenery;
import org.apache.log4j.Logger;

public class PopulationHandler {
	
	Logger logger = Logger.getLogger(PopulationHandler.class);

	double bestSelected = 0.30;
	double worstSelected = 0.20;
	double mut = 0.1;
	double mix = 0.20;	
	
	Solution bestSolution = null;
	
	Random randomGenerator = new Random();
	
	SolutionCreator creator;
	SolutionSelector selector;
	SolutionMixer mixer;
	SolutionMutator mutator;	
	Scenery scenery;
	
	int popSize;
	

	public PopulationHandler(Scenery scenery, int popSize) {
		super();
		this.popSize = popSize;
		this.scenery = scenery;
		this.creator = new SolutionCreator(scenery);
		this.mutator = new SolutionMutator();
		this.mixer = new SolutionMixer();
	}
	
	public Solution getBestSolution(){
		return bestSolution;
	}
	
	public double getBestFitness(){
		return selector.evaluate(bestSolution);
	}
	
	public Population createNewPop(){
		Population pop = new Population();
		for (int i = 0; i <popSize; i++) {
			pop.addSolution(creator.generateSolution());
		}
		return pop;
	}
	
	public Population envoiramentEffect(Population pop){
		selector = new SolutionSelector(pop);
		List<Solution> bestOnes = selector.getBestSolutions(bestSelected);
		List<Solution> worstOnes = selector.getWorstSolutions(worstSelected);
		List<Solution> mutated = getMutated(bestOnes, (int)(popSize*mut));
		List<Solution> mixed1 = getMixed(bestOnes, worstOnes, (int)(popSize*mix));
		List<Solution> mixed2 = getMixed(mutated, worstOnes, (int)(popSize*mix));
		
		List<Solution> ret = new ArrayList<Solution>();
		ret.addAll(bestOnes);
		ret.addAll(worstOnes);
		ret.addAll(mutated);		
		ret.addAll(mixed1);
		ret.addAll(mixed2);
		Population popRet = new Population();
		
		popRet.addAll(ret);
		bestSolution = bestOnes.get(0);
		return popRet;
	}
		
	private List<Solution> getMixed(List<Solution> firstOnes, List<Solution> secondOnes, int iterations){
		List<Solution> mixed = new ArrayList<Solution>();
		for (int i = 0; i < iterations; i++) {
			Solution selectOne = selectOneRandom(firstOnes);
			Solution selectTwo = selectOneRandom(secondOnes);
			mixed.add(mixer.mixSolutions(selectOne, selectTwo));
		}
		return mixed;
	}
			
	private List<Solution> getMutated(List<Solution> solutions, int iterations){
		List<Solution> mutated = new ArrayList<Solution>();
		for (int i = 0; i < iterations; i++) {
			mutated.add(mutator.mutateSolution(solutions.get(i)));
		}
		return mutated;
	}
			
	private Solution selectOneRandom(List<Solution> solutions){
		int random = randomGenerator.nextInt(solutions.size()-1);
		return solutions.get(random);
	}
	
}
