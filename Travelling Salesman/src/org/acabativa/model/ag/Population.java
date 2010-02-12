package org.acabativa.model.ag;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Population {

	Set<Solution> solutions = new HashSet<Solution>();

	public Set<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(Set<Solution> solutions) {
		this.solutions = solutions;
	}
	
	public void addSolution(Solution solution) {
		this.solutions.add(solution);
	}
	
	public void addAll(Collection<Solution> solutions) {
		this.solutions.addAll(solutions);
	}
	
	
	
}
