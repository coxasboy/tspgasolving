package org.acabativa.model.ag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.acabativa.model.actors.City;

public class SolutionMixer {
	double mixPercentage = 0.5;
	Random r = new Random();
	
	
	public Solution mixSolutions(Solution solutionA, Solution solutionB){
		List<City> citysA = solutionA.getItinerary();
		List<City> citysB = solutionB.getItinerary();
		List<City> ret = mix(citysA, citysB);
		return new Solution(ret);	
	}

	private List<City> mix(List<City> solutionA, List<City> solutionB){
			
		int numberMixed = (int) (solutionA.size() * mixPercentage);
		numberMixed = r.nextInt(numberMixed);
		
		int begin = r.nextInt(solutionA.size()-numberMixed-1);
		
		List<City> ret = new ArrayList<City>();
		for (int i = begin; i < numberMixed+begin; i++) {
			ret.add(solutionA.get(i));
		}

		for (City city : solutionB) {
			if (!ret.contains(city)) {
				ret.add(city);
			}
		}

		return ret;
	}

}
