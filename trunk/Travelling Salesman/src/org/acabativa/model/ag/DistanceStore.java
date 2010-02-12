package org.acabativa.model.ag;

import org.acabativa.model.actors.City;

public class DistanceStore {

	City cityA;
	City cityB;
		
	public DistanceStore(City cityA, City cityB) {
		super();
		this.cityA = cityA;
		this.cityB = cityB;	
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityA == null) ? 0 : cityA.hashCode());
		result = prime * result + ((cityB == null) ? 0 : cityB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistanceStore other = (DistanceStore) obj;
		if (cityA == null) {
			if (other.cityA != null)
				return false;
		} else if (!cityA.equals(other.cityA))
			return false;
		if (cityB == null) {
			if (other.cityB != null)
				return false;
		} else if (!cityB.equals(other.cityB))
			return false;
		return true;
	}

	
	
	
		

}
