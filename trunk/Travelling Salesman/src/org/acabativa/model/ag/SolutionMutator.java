package org.acabativa.model.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.acabativa.model.actors.City;

public class SolutionMutator {
	
	int mutatePercentage = 20;
	Random randomGenerator = new Random();
	
	public SolutionMutator() {
		super();
	}
	
	public SolutionMutator(int mutatePercentage) {
		super();
		this.mutatePercentage = mutatePercentage;
	}

	public Solution mutateSolution(Solution solution){
		List<City> citys = new ArrayList<City>(solution.getItinerary().size());
		for (City city: solution.getItinerary()) {
			citys.add(city);
		}
		double value = ((double)randomGenerator.nextInt(mutatePercentage))/100d;
		int maxPosition = (int) (value*citys.size());
		for (int i = 0; i < maxPosition; i++) {
			switchPositions(citys);
		}
		return new Solution(citys);
	}
	
	private void switchPositions(List<City> citys){
		int maxPosition = citys.size()-1;
		int pos1 = randomGenerator.nextInt(maxPosition);
		int pos2 = randomGenerator.nextInt(maxPosition);
		Collections.swap(citys, pos1, pos2);
	}
	
}
