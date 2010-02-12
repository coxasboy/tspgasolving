package org.acabativa.model.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.acabativa.model.actors.City;
import org.acabativa.model.actors.Scenery;

public class SolutionCreator {

	Scenery scenery = null;
	
	public SolutionCreator(Scenery scenery) {
		super();
		this.scenery = scenery;
	}
	
	public Solution generateSolution(){
		List<City> aux = new ArrayList<City>(scenery.getCitys());
		Collections.shuffle(aux);
		return new Solution(aux);
	}
	
}
